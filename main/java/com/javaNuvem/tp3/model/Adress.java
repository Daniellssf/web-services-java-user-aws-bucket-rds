package com.javaNuvem.tp3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Adress {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String localidade;
    @JsonProperty
    private String uf;
    @JsonProperty
    private boolean erro = false;

    public Adress(String logradouro, String bairro, String localidade, String uf, boolean erro) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.erro = erro;
    }

    public Adress() {

    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        if(erro == false) {
            return "Endereco{" +
                    ", logradouro='" + logradouro + '\'' +
                    ", bairro='" + bairro + '\'' +
                    ", localidade='" + localidade + '\'' +
                    ", uf='" + uf + '\'' +
                    '}';
        }
        else return "O CEP não foi encontrado no nosso banco de dados.";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
