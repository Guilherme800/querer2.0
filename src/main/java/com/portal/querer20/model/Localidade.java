package com.portal.querer20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Localidade")
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;

    @OneToMany(mappedBy = "localidade")
    @JsonIgnore
    private List<Agencia> agencias = new ArrayList<>();

    @OneToOne(mappedBy = "localidade")
    @JsonIgnore
    private Regional regional;
    @OneToMany(mappedBy = "localidade")
    @JsonIgnore
    private List<PostoAtendimento> pA = new ArrayList<>();

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public List<PostoAtendimento> getpA() {
        return pA;
    }

    public void setpA(List<PostoAtendimento> pA) {
        this.pA = pA;
    }

    public Localidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
