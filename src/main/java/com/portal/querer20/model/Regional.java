package com.portal.querer20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Regional {

    @Id
    private Integer codigo;
    private String telefone;
    private List<Agencia> agencia = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "id_localidade")
    @JsonIgnore
    private Localidade localidade;
    @OneToMany(mappedBy = "funcionarios")
    private List<Funcionario> funcionario = new ArrayList<>();

    public Regional() {
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public List<Agencia> getAgencia() {
        return agencia;
    }

    public void setAgencia(List<Agencia> agencia) {
        this.agencia = agencia;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
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
