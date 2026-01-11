package service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {

    Scanner sc = new Scanner(System.in);

    ClienteService clienteService = new ClienteService();
    ProdutoService produtoService = new ProdutoService();
    VendasService vendasService = new VendasService(clienteService, produtoService);

    public MenuService() {
    }

    public void menuPrincipal() {
        int opc = -1;
        do {
            System.out.println();
            System.out.println("===========================");
            System.out.println("*****SISTEMA DE VENDAS*****");
            System.out.println("===========================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Buscar Cliente por nome");
            System.out.println("5 - Remover Cliente");
            System.out.println("===========================");
            System.out.println("6 - Cadastrar Produto");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Atualizar Produto");
            System.out.println("9 - Buscar Produto por nome");
            System.out.println("10 - Remover Produto");
            System.out.println("===========================");
            System.out.println("11 - Realizar Venda");
            System.out.println("12 - Listar Vendas");
            System.out.println("13 - Listar Vendas por Cliente: ");
            System.out.println("14 - Listar Vendas por Produto: ");
            System.out.println("===========================");
            System.out.println("0 - Sair");

            try {
                System.out.print("\nDigite um número: ");
                opc = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error. Informe apenas números");
                sc.nextLine();
            }

            switch (opc) {
                case 1:
                    clienteService.cadastrarCliente();
                    break;

                case 2:
                    clienteService.listarClientes();
                    break;

                case 3:
                    clienteService.atualizarCliente();
                    break;

                case 4:
                    clienteService.buscarClientePorNome();
                    break;

                case 5:
                    clienteService.removerCliente();
                    break;

                case 6:
                    produtoService.cadastrarProduto();
                    break;

                case 7:
                    produtoService.listarProdutos();
                    break;

                case 8:
                    produtoService.atualizarProduto();
                    break;

                case 9:
                    produtoService.buscarProdutoPorNome();
                    break;

                case 10:
                    produtoService.removerProduto();
                    break;

                case 11:
                    vendasService.realizarVenda();
                    break;

                case 12:
                    vendasService.listarVendas();
                    break;

                case 13:
                    vendasService.listarVendasPorCliente();
                    break;

                case 14:
                    vendasService.listarVendasPorProduto();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opc != 0);
    }
}
