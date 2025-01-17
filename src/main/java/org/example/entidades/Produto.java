package org.example.entidades;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long idProduto;
    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR", nullable = false)
    private Fornecedor fornecedor;

    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;

    @Column(name = "PRECO_CUSTO")
    private Double precoCusto;

    @Column(name = "PRECO_VENDA")
    private Double precoVenda;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Produto() {
    }

    public Produto(Long idProduto, Fornecedor fornecedor, String nomeProduto, Double precoCusto, Double precoVenda, String descricao) {
        this.idProduto = idProduto;
        this.fornecedor = fornecedor;
        this.nomeProduto = nomeProduto;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.descricao = descricao;


    }
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}

