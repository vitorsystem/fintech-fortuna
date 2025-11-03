package br.com.fiap.fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_CATEGORIA_TRANSACAO")
public class CategoriaTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_transacao")
    private int idCategoriaTransacao;

    @Column(name = "ds_categoria", nullable = false, unique = true)
    private String dsCategoria;

    public int getIdCategoriaTransacao() {
        return idCategoriaTransacao;
    }

    public void setIdCategoriaTransacao(int idCategoriaTransacao) {
        this.idCategoriaTransacao = idCategoriaTransacao;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }

    public void setDsCategoria(String dsCategoria) {
        this.dsCategoria = dsCategoria;
    }
}