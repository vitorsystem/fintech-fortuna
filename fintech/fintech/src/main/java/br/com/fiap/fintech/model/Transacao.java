package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "T_TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private int idTransacao;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private double valor;

    @CreationTimestamp
    @Column(name = "data_transacao", nullable = false, updatable = false)
    private LocalDate dataTransacao;

    // --- Relacionamentos ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_transacao", nullable = false)
    private TipoTransacao tipoTransacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria_transacao", nullable = false)
    private CategoriaTransacao categoriaTransacao;

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public CategoriaTransacao getCategoriaTransacao() {
        return categoriaTransacao;
    }

    public void setCategoriaTransacao(CategoriaTransacao categoriaTransacao) {
        this.categoriaTransacao = categoriaTransacao;
    }
}