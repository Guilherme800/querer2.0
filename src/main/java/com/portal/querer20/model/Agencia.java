package com.portal.querer20.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Agencia {
    @Id
    private Integer codigo;
    private String telefone;
    private Boolean unidadeDeNegocios;
    private Boolean trag;
    private Integer tragDestino;

    @OneToMany(mappedBy = "agencias")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

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


}
