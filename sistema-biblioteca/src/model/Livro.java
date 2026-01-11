package model;

import java.util.UUID;

public class Livro {

    private UUID idLivro;
    private String titulo;
    private String autor;
    private String ISBN;
    private String statusLivro;

    public Livro(UUID idLivro, String titulo, String autor, String ISBN) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.statusLivro = "Disponível";
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + ", Status Livro='" + statusLivro +'\'' +
                '}';
    }

    public UUID getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(UUID idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(String statusLivro) {
        this.statusLivro = statusLivro;
    }
}
