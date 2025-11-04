package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "T_INVESTIMENTO")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investimento")
    private int idInvestimento;

    @Column(name = "tipo_investimento", nullable = false, length = 50)
    private String tipoInvestimento;

    @Column(name = "valor_aplicado", nullable = false)
    private double valorAplicado;

    @Column(name = "rentabilidade_atual")
    private double rentabilidadeAtual;

    @CreationTimestamp
    @Column(name = "data_aplicacao", updatable = false)
    private LocalDate dataAplicacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    public double getRentabilidadeAtual() {
        return rentabilidadeAtual;
    }

    public void setRentabilidadeAtual(double rentabilidadeAtual) {
        this.rentabilidadeAtual = rentabilidadeAtual;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}