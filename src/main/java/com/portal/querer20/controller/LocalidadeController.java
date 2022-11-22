package com.portal.querer20.controller;

import com.portal.querer20.model.Localidade;
import com.portal.querer20.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/{id}")
    public Localidade buscarLocalidadePorCodigo (@PathVariable Integer id){

        return localidadeService.buscarLocalidadePorId(id);
    }

    @PostMapping
    public String cadastrarLocalidade (@RequestBody Localidade localidade){
        if (localidade.getEstado() == null || localidade.getEstado().equals("")){
            return "Estado obrigatório.";}
        if (localidade.getCidade() == null || localidade.getCidade().equals("")){
            return "Cidade obrigatório.";}
        if (localidade.getBairro() == null || localidade.getBairro().equals("")){
            return "Bairro obrigatório.";}
        localidadeService.cadastrarLocalidade(localidade);
        return "Localidade cadastrada com sucesso.";
    }

    @DeleteMapping ("/{id}")
    public String excluirLocalidade (@PathVariable Integer id){
        Boolean excluiu = localidadeService.deletarLocalidade(id);
        if (!excluiu){
            return "Localidade não encontrada.";
        }
        return "Localidade excluida com sucesso.";
    }

    @PutMapping ("/{id}")
    public String atualizarLocalidade(@PathVariable Integer id, @RequestBody Localidade localidade){
        Boolean atualizou = localidadeService.atualizarLocalidade(id, localidade);
        if (!atualizou){
            return "Localidade não encontrada.";
        }
        return "Localidade atualizada com sucesso.";
    }
}
