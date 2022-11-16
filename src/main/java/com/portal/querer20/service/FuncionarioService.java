package com.portal.querer20.service;

import com.portal.querer20.model.Funcionario;
import com.portal.querer20.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios (){
        return funcionarioRepository.findAll();
    }

}
