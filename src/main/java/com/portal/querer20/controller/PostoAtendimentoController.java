package com.portal.querer20.controller;

import com.portal.querer20.model.PostoAtendimento;
import com.portal.querer20.service.PostoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pa")
public class PostoAtendimentoController {

    @Autowired
    private PostoAtendimentoService postoAtendimentoService;

    @GetMapping
    public List<PostoAtendimento> listarPA (){
        return postoAtendimentoService.listarPA();
    }

}
