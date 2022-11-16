package com.portal.querer20.controller;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public List<Agencia> listarAgencia () {
        return agenciaService.listarAgencia();
    }

}
