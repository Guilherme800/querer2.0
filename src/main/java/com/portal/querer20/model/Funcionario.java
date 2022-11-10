package com.portal.querer20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    private Integer funcional;
    private String nome;
    private String email;
    private String cargo;
    private String ramal;
    private String telefoneCelular;

    @ManyToOne
    @JoinColumn(name = "regional_codigo")
    private Regional regionais;
    @ManyToOne
    @JoinColumn(name = "agencia_codigo")
    private Agencia agencias;
    @ManyToOne
    @JoinColumn(name = "pa_codigo")
    private PostoAtendimento pA;

    public Regional getRegionais() {
        return regionais;
    }

    public void setRegionais(Regional regionais) {
        this.regionais = regionais;
    }

    public Agencia getAgencias() {
        return agencias;
    }

    public void setAgencias(Agencia agencias) {
        this.agencias = agencias;
    }

    public PostoAtendimento getpA() {
        return pA;
    }

    public void setpA(PostoAtendimento pA) {
        this.pA = pA;
    }

    public Funcionario() {
    }

    public Integer getFuncional() {
        return funcional;
    }

    public void setFuncional(Integer funcional) {
        this.funcional = funcional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
