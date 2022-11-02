package com.portal.querer20.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;

    @OneToMany(mappedBy = "regional")
    private List<Regional> regional = new ArrayList<>();
    @OneToMany(mappedBy = "agencia")
    private List<Agencia> agencia = new ArrayList<>();
    @OneToMany(mappedBy = "postoAtendimento")
    private List<PostoAtendimento> postoAtendimento = new ArrayList<>();

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }

    public List<Agencia> getAgencia() {
        return agencia;
    }

    public void setAgencia(List<Agencia> agencia) {
        this.agencia = agencia;
    }

    public List<PostoAtendimento> getPostoAtendimento() {
        return postoAtendimento;
    }

    public void setPostoAtendimento(List<PostoAtendimento> postoAtendimento) {
        this.postoAtendimento = postoAtendimento;
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
