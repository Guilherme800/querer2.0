package com.portal.querer20.service;

import com.portal.querer20.model.Funcionario;
import com.portal.querer20.model.Localidade;
import com.portal.querer20.model.Regional;
import com.portal.querer20.repository.FuncionarioRepository;
import com.portal.querer20.repository.LocalidadeRepository;
import com.portal.querer20.repository.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionalService {

    @Autowired
    private RegionalRepository regionalRepository;
    @Autowired
    private LocalidadeRepository localidadeRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Regional> listarRegional (){
        return regionalRepository.findAll();
    }

    public Regional buscarRegionalPorCodigo (Integer codigo) {
        return regionalRepository.findByCodigo(codigo);
    }

    public Boolean excluirRegional (Integer codigo) {
        Regional regional = buscarRegionalPorCodigo(codigo);
        if (regional == null) {
            return false;
        }
        regionalRepository.delete(regional);
        return true;
    }

    public void cadastrarRegional (Regional regional) {

        List<Funcionario> funcionarios1 = new ArrayList<>();
        for (Funcionario funcionario : regional.getFuncionarios()) {
            Funcionario funcionario1;
            if (funcionarioRepository.findByFuncional(funcionario.getFuncional()) != null) {
                funcionario1 = funcionarioRepository.findByFuncional(funcionario.getFuncional());
            } else {
                funcionario1 = funcionario;
            }
            funcionario1.setRegional(regional);
            funcionarioRepository.save(funcionario1);
            funcionarios1.add(funcionario1);
        }

        regionalRepository.save(regional);

    }
    public Boolean atualizarRegional (Integer codigo, Regional regional) {
        Regional regional1 = regionalRepository.findByCodigo(codigo);
        if (regional1 != null) {
            if (regional.getLocalidade() != null){
                regional1.setLocalidade(regional.getLocalidade());}
            if (regional.getTelefone() != null){
                regional1.setTelefone(regional.getTelefone());}
            if (regional.getCodigo() != null){
                regional1.setCodigo(regional.getCodigo());}
            if (regional.getFuncionarios() != null){
                regional1.setFuncionarios(regional.getFuncionarios());}
            regionalRepository.save(regional1);
            return true;
        }
        return false;
    }
}
