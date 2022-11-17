package com.portal.querer20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Regional")
public class Regional {

    @Id
    private Integer codigo;
    private String telefone;

    @OneToMany(mappedBy = "regional")
    private List<Funcionario> funcionarios = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

    @OneToMany(mappedBy = "regional")
    private List<Agencia> agencias = new ArrayList<>();

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
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


    public Regional() {
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
}
