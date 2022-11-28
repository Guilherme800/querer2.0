package com.portal.querer20.controller;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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

    @GetMapping ("/{codigo}")
    public Agencia BuscarAgenciaPorCdigo (@PathVariable Integer codigo) {
        return null;
    }

    @PutMapping ("/{codigo}")
    public String atualizarAgencia (@PathVariable Integer codigo, @RequestBody Agencia agencia) {
        return null;
    }

    @DeleteMapping ("/{codigo}")
    public String deletarAgencia (@PathVariable Integer codigo) {
        return null;
    }

    @PostMapping
    public String cadastrarAgencia (@RequestBody Agencia agencia) {
        return null;
    }
}
