package com.portal.querer20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PostoAtendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String telefone;
    private Integer agenciaOrigem;

    @OneToMany(mappedBy = "pA")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

    @ManyToOne
    @JoinColumn(name = "agencia_codigo")
    private Agencia agencia;

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }


    public PostoAtendimento() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getAgenciaOrigem() {
        return agenciaOrigem;
    }

    public void setAgenciaOrigem(Integer agenciaOrigem) {
        this.agenciaOrigem = agenciaOrigem;
    }


}
