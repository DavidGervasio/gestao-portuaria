package com.david.gestaoportuaria.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "TB_CONTEINER")
public class Conteiner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // @Column(unique = true)
    @NonNull
    private String cliente;

    @NonNull
    private String numeroDoConteiner;

    @NonNull
    private int tipo;

    @NonNull
    private String status;

    @NonNull
    private String categoria;

    @ManyToMany
    List<Movimentacao> movimentacoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroDoConteiner() {
        return numeroDoConteiner;
    }

    public void setNumeroDoConteiner(String numeroDoConteiner) {
        this.numeroDoConteiner = numeroDoConteiner;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static boolean validarStatus(String tipoDeMovimentacao) {
        if (tipoDeMovimentacao.equalsIgnoreCase("Cheio") || tipoDeMovimentacao.equalsIgnoreCase("Vazio")) {
            return true;
        }
        return false;

    }

}
