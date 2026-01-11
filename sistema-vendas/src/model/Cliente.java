package model;

import java.util.UUID;

public class Cliente {

    private UUID idCliente;
    private String nomeCliente;
    private String emailCliente;

    public Cliente() {
    }

    public Cliente(UUID idCliente, String nomeCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Override
    public String toString() {
        return "Cliente: {id: " + idCliente + " | Nome: " + nomeCliente + "| Email: " + emailCliente + "}";
    }
}
