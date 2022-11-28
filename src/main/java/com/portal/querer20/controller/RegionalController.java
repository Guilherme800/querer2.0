package com.portal.querer20.controller;

import com.portal.querer20.model.Regional;
import com.portal.querer20.service.RegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regional")
public class RegionalController {

    @Autowired
    private RegionalService regionalService;

    @PostMapping
    public String cadastrarRegional (@RequestBody Regional regional) {
        if (regional.getCodigo() == null || regional.getCodigo().equals("")){
            return "Codigo obrigatório.";}
        if (regional.getLocalidade() == null || regional.getLocalidade().equals("")){
            return "Localidade obrigatória.";}
        if (regional.getTelefone() == null || regional.getTelefone().equals("")){
            return "Telefone obrigatório.";}
        if (regional.getFuncionarios() == null || regional.getFuncionarios().equals("")){
            return "Funcionario obrigatório.";}
        regionalService.cadastrarRegional(regional);
        return "Regional cadastrada com sucesso.";
    }

    @PutMapping("/{codigo}")
    public String atualizarRegional (@PathVariable Integer codigo, @RequestBody Regional regional) {
        Boolean atualizou = regionalService.atualizarRegional(codigo, regional);
        if(!atualizou){
            return "Regional não encontrada.";
        }
        return "Regional atualizada com sucesso.";
    }

    @DeleteMapping("/{codigo}")
    public String excluirRegional (@PathVariable Integer codigo) {
        Boolean excluiu = regionalService.excluirRegional(codigo);
        if (!excluiu) {
            return "Regional não localizada.";
        }
        return "Regional excluida.";
    }

    @GetMapping("/{codigo}")
    public Regional buscarRegionalPorCodigo (@PathVariable Integer codigo) {
        return regionalService.buscarRegionalPorCodigo(codigo);
    }

    @GetMapping
    public List<Regional> listarRegional (){
        return regionalService.listarRegional();
    }



}
