package com.portal.querer20.model;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private Integer codigo;
    private String telefone;
    private Boolean unidadeDeNegocios;
    private Boolean trag;
    private Integer tragDestino;

    private List<Funcionario> funcionarios = new ArrayList<>();
    private Localidade localidade;

    public Agencia() {
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

    public Boolean getUnidadeDeNegocios() {
        return unidadeDeNegocios;
    }

    public void setUnidadeDeNegocios(Boolean unidadeDeNegocios) {
        this.unidadeDeNegocios = unidadeDeNegocios;
    }

    public Boolean getTrag() {
        return trag;
    }

    public void setTrag(Boolean trag) {
        this.trag = trag;
    }

    public Integer getTragDestino() {
        return tragDestino;
    }

    public void setTragDestino(Integer tragDestino) {
        this.tragDestino = tragDestino;
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
}
