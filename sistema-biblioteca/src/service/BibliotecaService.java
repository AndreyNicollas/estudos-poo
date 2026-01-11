package service;

import model.Biblioteca;
import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class BibliotecaService {

    public static ArrayList<Biblioteca> bibliotecaList = new ArrayList<>();

    public static void emprestimoLivro() {
        Scanner sc = new Scanner(System.in);
        if (UsuarioService.usuarioList.isEmpty() || LivroService.livrosList.isEmpty()) {
            System.out.println("É necessário ter usuários e livros cadastrados para realizar um empréstimo.");
            return;
        }

        try {
            System.out.print("Informe o ID do usuário para realizar o emprestimo: ");
            UUID idUsuario = UUID.fromString(sc.nextLine());
            System.out.print("Informe o ID do livro que deseja pegar emprestado: ");
            UUID idLivro = UUID.fromString(sc.nextLine());

            Usuario usuario = null;
            for (Usuario u : UsuarioService.usuarioList) {
                if (u.getIdUsuario().equals(idUsuario)) {
                    usuario = u;
                    break;
                }
            }

            Livro livro = null;
            for (Livro l : LivroService.livrosList) {
                if (l.getIdLivro().equals(idLivro)) {
                    livro = l;
                    break;
                }
            }

            if (!livro.getStatusLivro().equalsIgnoreCase("Disponível")) {
                System.out.println("Error. O livro já está emprestado ou indisponível.");
                return;
            }

            livro.setStatusLivro("Emprestado");
            Biblioteca biblioteca = new Biblioteca(usuario, livro);
            bibliotecaList.add(biblioteca);
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println("O livro: " + livro.getTitulo() + ", foi emprestado para o usuário: " + usuario.getNome());
        } catch (IllegalArgumentException e) {
            System.out.println("Error. O ID informado é inválido.");
        }
    }

    public static void listarEmprestimosBiblioteca() {
        if (bibliotecaList.isEmpty()) {
            System.out.println("Nenhum empréstimo foi realizado.");
        } else {
            System.out.println("Lista de empréstimos: ");
            for (Biblioteca b : bibliotecaList) {
                System.out.println(b.toString());
            }
            System.out.println("\nTotal de empréstimos: " + bibliotecaList.size());
        }
    }

    public static void devolverLivroBiblioteca() {
        Scanner sc = new Scanner(System.in);
        if (UsuarioService.usuarioList.isEmpty() || LivroService.livrosList.isEmpty()) {
            System.out.println("É necessário ter usuários e livros cadastrados para realizar a devolução.");
            return;
        }

        try {
            System.out.print("Informe o ID do usuário para realizar a devolução: ");
            UUID idUsuarioDevolver = UUID.fromString(sc.nextLine());
            System.out.print("Informe o ID do livro que deseja realizar a devolução: ");
            UUID idLivroDevolver = UUID.fromString(sc.nextLine());

            Biblioteca emprestimoEncontrado = null;
            for (Biblioteca b : bibliotecaList) {
                Usuario usuario = b.getUsuario();
                Livro livro = b.getLivro();

                if (usuario.getIdUsuario().equals(idUsuarioDevolver) && livro.getIdLivro().equals(idLivroDevolver)) {
                    emprestimoEncontrado = b;
                    break;
                }
            }

            if (emprestimoEncontrado != null) {
                emprestimoEncontrado.getLivro().setStatusLivro("Disponível");
                bibliotecaList.remove(emprestimoEncontrado);
                System.out.println("O livro '" + emprestimoEncontrado.getLivro().getTitulo() + "', foi devolvido com sucesso.");
            } else {
                System.out.println("Não foi encontrado um empréstimo para este usuário.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error. O ID informado é inválido.");
        }
    }
}
