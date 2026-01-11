package model;

public class Biblioteca {

    private Usuario usuario;
    private Livro livro;

    public Biblioteca(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.livro.getStatusLivro();
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "usuario=" + usuario +
                ", livro=" + livro + ", Status livro: " + livro.getStatusLivro() + '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
