package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UsuarioService {

    public static ArrayList<Usuario> usuariosList = new ArrayList<>();

    public static void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        System.out.print("Informe o nome do usuário: ");
        String nome = sc.nextLine();
        System.out.print("Informe uma senha para este usuário: ");
        String senha = sc.nextLine();

        Usuario usuario = new Usuario(id, nome, senha);
        usuariosList.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public static void listarUsuarios() {
        if (usuariosList.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado no momento.");
        } else {
            System.out.println("\nLista de usuários cadastrados: ");
            for (Usuario u : usuariosList) {
                System.out.println(u);
            }
        }
    }

    public static void removerUsuarioPorId() {
        Scanner sc = new Scanner(System.in);
        if (usuariosList.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o  ID do usuário para remover: ");
                UUID removerUsuarioPorId = UUID.fromString(sc.nextLine());
                for (Usuario u: usuariosList) {
                    if (u.getIdUsuario().equals(removerUsuarioPorId)) {
                        usuariosList.remove(u);
                        System.out.println("Usuário removido com sucesso!");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }
}
