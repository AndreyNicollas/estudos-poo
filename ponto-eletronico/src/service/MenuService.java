package service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static service.PontoService.*;
import static service.UsuarioService.*;

public class MenuService {
    public static void menuService() {
        Scanner sc = new Scanner(System.in);

        int opc = -1;
        do {
            System.out.println("\n=====================");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuário");
            System.out.println("3 - Remover usuário por ID");
            System.out.println("=====================");
            System.out.println("4 - Registrar entrada");
            System.out.println("5 - Registrar saída");
            System.out.println("6 - Listar frequência de pontos");
            System.out.println("7 - Gerar comprovante de ponto");
            System.out.println("=====================");
            System.out.println("0 - Sair");

            try {
                System.out.print("\n>>> Digite um número: ");
                opc = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error. Informe apenas números.");
            }

            switch (opc) {
                case 1:
                    cadastrarUsuario();
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    removerUsuarioPorId();
                    break;

                case 4:
                    registrarEntrada();
                    break;

                case 5:
                    registrarSaida();
                    break;

                case 6:
                    listarPontos();
                    break;

                case 7:
                    comprovantePonto();
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
