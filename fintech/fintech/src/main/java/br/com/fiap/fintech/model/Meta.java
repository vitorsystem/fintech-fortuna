package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_META")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private int idMeta;

    @Column(name = "nome_meta", nullable = false, length = 100)
    private String nomeMeta;

    @Column(name = "valor_objetivo", nullable = false)
    private double valorObjetivo;

    @Column(name = "data_limite")
    private LocalDate dataLimite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}