package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ponto {

    private Usuario usuario;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Ponto(Usuario usuario, LocalDateTime entrada, LocalDateTime saida) {
        this.usuario = usuario;
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {

        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String entradaFormatada;
        entradaFormatada = entrada.format(dateTimeFormatter);

        String saidaFormatada;
        if (saida == null) {
            saidaFormatada = "Em aberto.";
        } else {
            saidaFormatada = saida.format(dateTimeFormatter);
        }

        return usuario + " | Horário de entrada: " + entradaFormatada + " | Horário de saída: " + saidaFormatada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
}
