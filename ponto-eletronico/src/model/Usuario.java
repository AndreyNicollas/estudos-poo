package model;

import java.util.UUID;

public class Usuario {

    private UUID idUsuario;
    private String nomeUsuario;
    private String senha;

    public Usuario(UUID idUsuario, String nomeUsuario, String senha) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ID: " + idUsuario + " | Nome: " + nomeUsuario + " | Senha: " + senha;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
