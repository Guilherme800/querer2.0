package com.portal.querer20.service;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<Agencia> listarAgencia(){
        return agenciaRepository.findAll();
    }

}
