package com.portal.querer20.controller;

import com.portal.querer20.model.Localidade;
import com.portal.querer20.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping
    public List<Localidade> listarLocalidade() {
        return localidadeService.listarLocalidades();
    }

}
