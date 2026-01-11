package service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static service.BibliotecaService.*;
import static service.LivroService.*;
import static service.UsuarioService.*;

public class MenuService {
    public static void menuService() {
        Scanner sc = new Scanner(System.in);

        int opc = -1;
        do {
            System.out.println();
            System.out.println("======================");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livro");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Remover livro");
            System.out.println("======================");
            System.out.println("6 - Cadastrar usuario");
            System.out.println("7 - Listar usuario");
            System.out.println("8 - Remover usuario");
            System.out.println("======================");
            System.out.println("9 - Emprestar livro");
            System.out.println("10 - Listar empréstimos");
            System.out.println("11 - Devolver livro");
            System.out.println("0 - Sair");

            try {
                System.out.print("\nDigite um número: ");
                opc = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error. Informe apenas números.");
            }

            switch (opc) {
                case 1:
                    cadastrarLivro();
                    break;

                case 2:
                    listarLivros();
                    break;

                case 3:
                    buscarLivroPorId();
                    break;

                case 4:
                    atualizarLivroPorId();
                    break;

                case 5:
                    removerLivroPorId();
                    break;

                case 6:
                    cadastrarUsuario();
                    break;

                case 7:
                    listarUsuarios();
                    break;

                case 8:
                    removerUsuarioPorId();
                    break;

                case 9:
                    emprestimoLivro();
                    break;

                case 10:
                    listarEmprestimosBiblioteca();
                    break;

                case 11:
                    devolverLivroBiblioteca();
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
