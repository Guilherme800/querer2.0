package com.portal.querer20.service;

import com.portal.querer20.model.Funcionario;
import com.portal.querer20.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios (){
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> buscarPorNome (String nome){
        return funcionarioRepository.findByNome(nome);
    }

    public Funcionario buscarPorFuncional (Integer funcional) {
        return funcionarioRepository.findByFuncional(funcional);
    }

    public void adicionarFuncionario (Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }

    public Boolean excluirFuncionario (Integer funcional) {
        Funcionario funcionario = funcionarioRepository.findByFuncional(funcional);
        if(funcionario != null){
            funcionarioRepository.delete(funcionario);
            return true;
        }
        return false;
    }

    public Boolean atualizarFuncionario (Integer funcional, Funcionario funcionario) {
        Funcionario funcionario1 = buscarPorFuncional(funcional);
        if(funcionario != null){
            if (funcionario.getAgencia() != null){
                funcionario1.setAgencia(funcionario.getAgencia());}
            if (funcionario.getCargo() != null){
                funcionario1.setCargo(funcionario.getCargo());}
            if (funcionario.getEmail() != null){
                funcionario1.setEmail(funcionario.getEmail());}
            if (funcionario.getFuncional() != null){
                funcionario1.setFuncional(funcionario.getFuncional());}
            if (funcionario.getNome() != null){
                funcionario1.setNome(funcionario.getNome());}
            if (funcionario.getpA() != null){
                funcionario1.setpA(funcionario.getpA());}
            if (funcionario.getRamal() != null){
                funcionario1.setRamal(funcionario.getRamal());}
            if (funcionario.getRegional() != null){
                funcionario1.setRegional(funcionario.getRegional());}
            if (funcionario.getTelefoneCelular() != null){
                funcionario1.setTelefoneCelular(funcionario.getTelefoneCelular());}
            funcionarioRepository.save(funcionario1);
            return true;
        }
        return false;
    }

}
