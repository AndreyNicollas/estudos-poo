package service;

import model.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class ProdutoService {

    public ArrayList<Produto> produtoList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ProdutoService() {
    }

    public void cadastrarProduto() {
        UUID idProduto = UUID.randomUUID();
        System.out.print("Informe o nome do Produto: ");
        String nomeProduto = sc.nextLine();

        try {
            System.out.print("Informe a quantidade do Produto: ");
            int quantidadeProduto = sc.nextInt();
            System.out.print("Informe o preço do Produto: ");
            double valorProduto = sc.nextDouble();
            sc.nextLine();

            if (quantidadeProduto <= 0) {
                System.out.println("A quantidade informada deve ser maior que zero.");
                return;
            }

            if (valorProduto <= 0) {
                System.out.println("O preço do produto informado deve ser maior que zero.");
                return;
            }

            Produto produto = new Produto(idProduto, nomeProduto, quantidadeProduto, valorProduto);
            produtoList.add(produto);
            System.out.println("Produto cadastrado.");
        } catch (InputMismatchException e) {
            System.out.println("Error. O valor informado é inválido.");
            sc.nextLine();
        }
    }

    public void listarProdutos() {
        if (produtoList.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("\n=====LISTA DE PRODUTOS=====");
            for (Produto p : produtoList) {
                System.out.println(p);
            }
        }
    }

    public void atualizarProduto() {
        if (produtoList.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            try {
                System.out.print("Informe o id do Produto que deseja atualizar: ");
                UUID idProdutoBuscar = UUID.fromString(sc.nextLine());

                Produto produtoEncontrado = null;

                for (Produto p : produtoList) {
                    if (p.getIdProduto().equals(idProdutoBuscar)) {
                        produtoEncontrado = p;
                        break;
                    }
                }

                if (produtoEncontrado != null) {
                    try {
                        System.out.print("Informe a nova quantidade do Produto: ");
                        int novaQuantidadeProduto = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Informe o novo preço do Produto: ");
                        double novoPrecoProduto = sc.nextDouble();
                        sc.nextLine();

                        if (novaQuantidadeProduto <= 0 || novoPrecoProduto <= 0) {
                            System.out.println("A quantidade ou preço deve ser maior que zero.");
                        } else {
                            int novoEstoqueTotalProduto = produtoEncontrado.getQuantidadeProduto() + novaQuantidadeProduto;
                            produtoEncontrado.setQuantidadeProduto(novoEstoqueTotalProduto);
                            produtoEncontrado.setPrecoProduto(novoPrecoProduto);
                            System.out.print("Dados atualizados com sucesso!\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error. O valor informado é inválido.");
                    }
                } else {
                    System.out.println("Produto não encontrado.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado inválido.");
            }
        }
    }

    public void removerProduto() {
        if (produtoList.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o id do Produto para remover: ");
                UUID idProdutoRemover = UUID.fromString(sc.nextLine());
                for (Produto p : produtoList) {
                    if (p.getIdProduto().equals(idProdutoRemover)) {
                        produtoList.remove(p);
                        System.out.println("Produto foi removido.");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado inválido.");
            }
        }
    }

    public void buscarProdutoPorNome() {
        if (produtoList.isEmpty()) {
            System.out.println("Nenhum produto foi encontrado no momento.");
        } else {
            try {
                System.out.print("Informe o nome do Produto para buscar: ");
                String nomeProdutoBuscar = sc.nextLine();

                for (Produto p : produtoList) {
                    if (p.getNomeProduto().toLowerCase().contains(nomeProdutoBuscar.toLowerCase())) {
                        System.out.println("Produto foi encontrado.");
                        System.out.println("Dados do Produto: " + p);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado inválido.");
            }
        }
    }
}
