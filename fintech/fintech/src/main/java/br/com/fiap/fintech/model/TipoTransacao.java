package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_TIPO_TRANSACAO")
public class TipoTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_transacao")
    private int idTipoTransacao;

    @Column(name = "ds_tipo_transacao", nullable = false, unique = true)
    private String dsTipoTransacao;

    public int getIdTipoTransacao() {
        return idTipoTransacao;
    }

    public void setIdTipoTransacao(int idTipoTransacao) {
        this.idTipoTransacao = idTipoTransacao;
    }

    public String getDsTipoTransacao() {
        return dsTipoTransacao;
    }

    public void setDsTipoTransacao(String dsTipoTransacao) {
        this.dsTipoTransacao = dsTipoTransacao;
    }
}