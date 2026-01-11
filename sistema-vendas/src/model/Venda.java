package model;

import java.util.UUID;

public class Venda {

    private UUID idVenda;
    private Cliente cliente;
    private Produto produto;
    private int quantidadeComprada;

    public Venda() {
    }

    public Venda(UUID idVenda, Cliente cliente, Produto produto, int quantidadeComprada) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public UUID getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(UUID idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    private double calcularTotal() {
        return produto.getPrecoProduto() * quantidadeComprada;
    }

    @Override
    public String toString() {
        return "\nDados da Venda: \n" +
                "idVenda: " + idVenda +
                "\n" + cliente +
                "\nProduto: {id: " + produto.getIdProduto() + " | Nome do produto: " + produto.getNomeProduto()
                + " | Valor unitário do Produto: " + produto.getPrecoProduto() + "}"  +
                "\nQuantidade comprada: " + quantidadeComprada + "\nValor Total: " + String.format("%.2f", calcularTotal());
    }
}
