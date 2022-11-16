package com.portal.querer20.service;

import com.portal.querer20.model.PostoAtendimento;
import com.portal.querer20.repository.PostoAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoAtendimentoService {

    @Autowired
    private PostoAtendimentoRepository postoAtendimentoRepository;

    public List<PostoAtendimento> listarPA (){
        return postoAtendimentoRepository.findAll();
    }

}
