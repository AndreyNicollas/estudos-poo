package service;

import model.Livro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class LivroService {

    public static ArrayList<Livro> livrosList = new ArrayList<>();

    public static void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        System.out.print("Informe o titulo do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Informe o nome do autor: ");
        String autor = sc.nextLine();
        System.out.print("Digite o número ISBN: ");
        String isbn = sc.nextLine();

        Livro livro = new Livro(id, titulo, autor, isbn);
        livrosList.add(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    public static void listarLivros() {
        if (livrosList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento.");
        } else {
            System.out.println("Lista de livros: ");
            for (Livro l : livrosList) {
                System.out.println(l);
            }
        }
    }

    public static void buscarLivroPorId() {
        Scanner sc = new Scanner(System.in);
        if (livrosList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do livro para buscar: ");
                UUID idLivroBuscar = UUID.fromString(sc.nextLine());
                for (Livro l : livrosList) {
                    if (l.getIdLivro().equals(idLivroBuscar)) {
                        System.out.println("Livro encontrado.");
                        System.out.println("Dados do livro: " + l);
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }

    public static void removerLivroPorId() {
        Scanner sc = new Scanner(System.in);
        if (livrosList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do livro para remover: ");
                UUID idLivroRemover = UUID.fromString(sc.nextLine());
                for (Livro l : livrosList) {
                    if (l.getIdLivro().equals(idLivroRemover)) {
                        livrosList.remove(l);
                        System.out.println("O livro foi removido.");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }

    public static void atualizarLivroPorId() {
        Scanner sc = new Scanner(System.in);
        if (livrosList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento.");
        } else {
            try {
                System.out.print("Informe o ID do livro que deseja atualizar: ");
                UUID idClienteBuscar = UUID.fromString(sc.nextLine());

                Livro livroIsPresent = null;
                for (Livro l : livrosList) {
                    if (l.getIdLivro().equals(idClienteBuscar)) {
                        livroIsPresent = l;
                        break;
                    }
                }

                if (livroIsPresent != null) {
                    System.out.print("Informe o novo titulo para o livro: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Informe o novo autor do livro: ");
                    String novoAutor = sc.nextLine();
                    System.out.print("Informe o novo ISBN do livro: ");
                    String novoIsbn = sc.nextLine();

                    livroIsPresent.setTitulo(novoTitulo);
                    livroIsPresent.setAutor(novoAutor);
                    livroIsPresent.setISBN(novoIsbn);
                    System.out.println("Os dados do livro foram atualizados com sucesso.");
                } else {
                    System.out.println("O livro não foi encontrado.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error. O ID informado é inválido.");
            }
        }
    }
}
