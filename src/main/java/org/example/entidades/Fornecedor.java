package org.example.entidades;

import javax.persistence.*;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORNECEDOR")
    private Long idFornecedor;

    @Column(name = "NOME_FORNECEDOR")
    private String nomeFornecedor;

    @Column(name = "EMAIL")
    private String email;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor, String nomeFornecedor, String email) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.email = email;
    }

    //retorna valor
    public Long getIdFornecedor() {
        return idFornecedor;
    }

    //cadastrar,inserir
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
