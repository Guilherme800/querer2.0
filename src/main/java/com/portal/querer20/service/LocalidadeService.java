package com.portal.querer20.service;

import com.portal.querer20.model.Localidade;
import com.portal.querer20.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public List<Localidade> listarLocalidades () {
        return localidadeRepository.findAll();
    }

}
