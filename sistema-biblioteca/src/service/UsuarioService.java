package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UsuarioService {

    public static ArrayList<Usuario> usuarioList = new ArrayList<>();

    public static void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        System.out.print("Informe o nome do usuário: ");
        String nome = sc.nextLine();
        System.out.print("Informe o cpf do usuário: ");
        String cpf = sc.nextLine();

        Usuario usuario = new Usuario(id, nome, cpf);
        usuarioList.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public static void listarUsuarios() {
        if (usuarioList.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado no momento.");
        } else {
            System.out.println("Lista de usuários: ");
            for (Usuario u : usuarioList) {
                System.out.println(u);
            }
        }
    }

    public static void removerUsuarioPorId() {
        Scanner sc = new Scanner(System.in);
        if (usuarioList.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do usuário para remover: ");
                UUID idUsuarioRemover = UUID.fromString(sc.nextLine());
                for (Usuario u : usuarioList) {
                    if (u.getIdUsuario().equals(idUsuarioRemover)) {
                        usuarioList.remove(u);
                        System.out.println("O usuário foi removido.");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }
}
