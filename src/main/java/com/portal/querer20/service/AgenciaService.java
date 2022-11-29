package com.portal.querer20.service;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.model.Funcionario;
import com.portal.querer20.model.Regional;
import com.portal.querer20.repository.AgenciaRepository;
import com.portal.querer20.repository.FuncionarioRepository;
import com.portal.querer20.repository.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private RegionalRepository regionalRepository;

    public List<Agencia> listarAgencia(){
        return agenciaRepository.findAll();
    }

    public Agencia buscarAgenciaPorCodigo (Integer codigo) {
        return agenciaRepository.findByCodigo(codigo);
    }

    public Boolean atualizarAgencia (Integer codigo, Agencia agencia) {
        Agencia agencia1 = agenciaRepository.findByCodigo(codigo);
        if (agencia1 !=null) {
            if (agencia.getFuncionarios() != null){
                agencia1.setFuncionarios(agencia.getFuncionarios());}
            if (agencia.getCodigo() != null){
                agencia1.setCodigo(agencia.getCodigo());}
            if (agencia.getLocalidade() != null){
                agencia1.setLocalidade(agencia.getLocalidade());}
            if (agencia.getRegional() != null){
                agencia1.setRegional(agencia.getRegional());}
            if (agencia.getUnidadeDeNegocios() != null){
                agencia1.setUnidadeDeNegocios(agencia.getUnidadeDeNegocios());}
            if (agencia.getTelefone() != null){
                agencia1.setTelefone(agencia.getTelefone());}
            agenciaRepository.save(agencia1);
            return true;
        }
        return false;
    }

    public Boolean deletarAgencia (Integer codigo) {
        Agencia agencia = agenciaRepository.findByCodigo(codigo);
        if (agencia == null) {
            return false;
        }
        agenciaRepository.delete(agencia);
        return true;
    }

    public void adicionarAgencia (Agencia agencia) {

        List<Funcionario> funcionarios1 = new ArrayList<>();
        for (Funcionario funcionario : agencia.getFuncionarios()) {
            Funcionario funcionario1;
            if (funcionarioRepository.findByFuncional(funcionario.getFuncional()) != null) {
                funcionario1 = funcionarioRepository.findByFuncional(funcionario.getFuncional());
            } else {
                funcionario1 = funcionario;
            }
            funcionario1.setAgencia(agencia);
            funcionarioRepository.save(funcionario1);
            funcionarios1.add(funcionario1);
        }
        agencia.setRegional(regionalRepository.findByCodigo(agencia.getRegional().getCodigo()));

        agenciaRepository.save(agencia);
    }

}
