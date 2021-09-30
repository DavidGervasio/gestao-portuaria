package com.david.gestaoportuaria.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "TB_MOVIMENTACAO")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NonNull
    long idConteiner;

    @NonNull
    String tipoDeMovimentacao;

    @NonNull
    Date dataEHoraDoInicio;

    @NonNull
    Date dataEHoraDoFim;

    @ManyToOne
    Conteiner conteiner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdConteiner() {
        return idConteiner;
    }

    public void setIdConteiner(long idConteiner) {
        this.idConteiner = idConteiner;
    }

    public String getTipoDeMovimentacao() {
        return tipoDeMovimentacao;
    }

    public void setTipoDeMovimentacao(String tipoDeMovimentacao) {
        this.tipoDeMovimentacao = tipoDeMovimentacao;
    }

    public Date getDataEHoraDoInicio() {
        return dataEHoraDoInicio;
    }

    public void setDataEHoraDoInicio(Date dataEHoraDoInicio) {
        this.dataEHoraDoInicio = dataEHoraDoInicio;
    }

    public Date getDataEHoraDoFim() {
        return dataEHoraDoFim;
    }

    public void setDataEHoraDoFim(Date dataEHoraDoFim) {
        this.dataEHoraDoFim = dataEHoraDoFim;
    }
    
    public static boolean validarTipoDeMovimentacao(String tipoDeMovimentacao) {
        if (tipoDeMovimentacao.equals("embarque") || tipoDeMovimentacao.equals("descarga")
                || tipoDeMovimentacao.equals("gate in") || tipoDeMovimentacao.equals("gate out")
                || tipoDeMovimentacao.equals("reposicionamento") || tipoDeMovimentacao.equals("pesagem")
                || tipoDeMovimentacao.equals("scanner")) {
            return true;
        }
        return false;

    }

}
