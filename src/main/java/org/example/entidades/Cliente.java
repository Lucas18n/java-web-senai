package org.example.entidades;
import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;


    @Column(name = "CPF")
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nomeCliente, String telefone, String cpf) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;

    }

    public Long getidCliente() {
        return idCliente;
    }

    public void setidCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
