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

        return agenciaService.buscarAgenciaPorCodigo(codigo);
    }

    @PutMapping ("/{codigo}")
    public String atualizarAgencia (@PathVariable Integer codigo, @RequestBody Agencia agencia) {
        Boolean atualizou = agenciaService.atualizarAgencia(codigo, agencia);
        if(!atualizou){
            return "Agencia não encontrada.";
        }
        return "Agencia atualizada com sucesso.";
    }

    @DeleteMapping ("/{codigo}")
    public String deletarAgencia (@PathVariable Integer codigo) {
        Boolean deletou = agenciaService.deletarAgencia(codigo);
        if (!deletou){
            return "Agencia não encontrada.";
    }
        return "Agencia deletada com sucesso.";
    }

    @PostMapping
    public String cadastrarAgencia (@RequestBody Agencia agencia) {
        return null;
    }
}
