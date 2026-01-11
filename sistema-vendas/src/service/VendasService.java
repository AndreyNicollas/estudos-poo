package service;

import model.Cliente;
import model.Produto;
import model.Venda;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class VendasService {

    Scanner sc = new Scanner(System.in);
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private ArrayList<Venda> vendasList = new ArrayList<>();

    public VendasService() {
    }

    public VendasService(ClienteService clienteService, ProdutoService produtoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public void realizarVenda() {
        if (clienteService.clienteList.isEmpty() || produtoService.produtoList.isEmpty()) {
            System.out.println("Nenhum Cliente ou Produto foram cadastrados no momento.");
            return;
        }

        try {
            System.out.print("Informe o id do Cliente para realizar a venda: ");
            UUID idCliente = UUID.fromString(sc.nextLine());
            System.out.print("Informe o id do Produto para para realizar a venda: ");
            UUID idProduto = UUID.fromString(sc.nextLine());
            System.out.print("Informe a quantidade do que deseja comprar: ");
            int quantidadeProdutoComprado = sc.nextInt();
            sc.nextLine();

            if (quantidadeProdutoComprado <= 0) {
                System.out.println("A quantidade informada deve ser maior que zero.");
                return;
            }

            Cliente cliente = null;
            for (Cliente c : clienteService.clienteList) {
                if (c.getIdCliente().equals(idCliente)) {
                    cliente = c;
                    break;
                }
            }

            Produto produto = null;
            for (Produto p : produtoService.produtoList) {
                if (p.getIdProduto().equals(idProduto)) {
                    produto = p;
                    break;
                }
            }

            if (cliente != null && produto != null) {
                if (produto.getQuantidadeProduto() < quantidadeProdutoComprado) {
                    System.out.println("Error. O estoque é insuficiente para o produto " + produto.getNomeProduto());
                    System.out.println("Não é possível realizar venda.");
                } else {
                    UUID idVenda = UUID.randomUUID();
                    Venda venda = new Venda(idVenda, cliente, produto, quantidadeProdutoComprado);
                    vendasList.add(venda);
                    System.out.println("Venda realizada!");
                    System.out.println(venda);
                    produto.setQuantidadeProduto(produto.getQuantidadeProduto() - quantidadeProdutoComprado);
                }
            } else {
                System.out.println("Cliente ou Produto não encontrados.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error. O id informado é inválido.");
        } catch (Exception e) {
            System.out.println("Error. Ocorreu um erro na entrada de dados.");
        }
    }

    public void listarVendas() {
        if (vendasList.isEmpty()) {
            System.out.println("Nenhuma venda foi realizada.");
        } else {
            System.out.print("\n======LISTA DE VENDAS======");
            for (Venda v : vendasList) {
                System.out.println(v);
            }
            System.out.println("\nTotal de Vendas: " + vendasList.size());
        }
    }

    public void listarVendasPorCliente() {
        if (vendasList.isEmpty()) {
            System.out.println("Nenhuma venda foi realizada.");
            return;
        } else {
            try {
                System.out.print("Informe o id do Cliente para listar as vendas por cliente: ");
                UUID idClienteListar = UUID.fromString(sc.nextLine());

                Cliente clienteListarVendas = null;
                for (Cliente c : clienteService.clienteList) {
                    if (c.getIdCliente().equals(idClienteListar)) {
                        clienteListarVendas = c;
                        break;
                    }
                }

                for (Venda v : vendasList) {
                    if (v.getCliente().getIdCliente().equals(idClienteListar)) {
                        System.out.println(v);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id informado é inválido.");
            }
        }
    }

    public void listarVendasPorProduto() {
        if (vendasList.isEmpty()) {
            System.out.println("Nenhuma venda foi realizada.");
        } else {
            try {
                System.out.print("Informe o id do Produto para listar as vendas por produto: ");
                UUID idProdutoListar = UUID.fromString(sc.nextLine());

                Produto produtoListarVendas = null;
                for (Produto p : produtoService.produtoList) {
                    if (p.getIdProduto().equals(idProdutoListar)) {
                        produtoListarVendas = p;
                        break;
                    }
                }

                int quantidadeTotalVendida = 0;
                if (produtoListarVendas != null) {
                    for (Venda v : vendasList) {
                        if (v.getProduto().getIdProduto().equals(idProdutoListar)) {
                            quantidadeTotalVendida += v.getQuantidadeComprada();
                        }
                    }
                }

                System.out.println("Nome do produto: " + produtoListarVendas.getNomeProduto());
                System.out.println("Quantidade total comprada: " + quantidadeTotalVendida);
                System.out.println("Quantidade total no estoque: " + produtoListarVendas.getQuantidadeProduto());
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O id do Produto inválido.");
            }
        }
    }
}
