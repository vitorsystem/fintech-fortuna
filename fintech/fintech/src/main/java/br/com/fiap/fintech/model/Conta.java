package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private int idConta;

    @Column(name = "nome_conta")
    private String nomeConta;

    @Column(name = "saldo_inicial")
    private double saldoInicial;

    @Column(name = "saldo_atual")
    private double saldoAtual;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}