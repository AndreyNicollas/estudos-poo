package model;

import java.util.UUID;

public class Produto {

    private UUID idProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private double precoProduto;

    public Produto() {
    }

    public Produto(UUID idProduto, String nomeProduto, int quantidadeProduto, double precoProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto = precoProduto;
    }

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produto: {id: " +idProduto + " | Nome do Produto: " + nomeProduto + " | Quantidade do Produto: " + quantidadeProduto
                + " | Preço do Produto: " + precoProduto + "}";
    }
}
