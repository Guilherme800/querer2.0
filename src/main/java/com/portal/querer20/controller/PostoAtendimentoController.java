package com.portal.querer20.controller;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.model.PostoAtendimento;
import com.portal.querer20.service.PostoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/{codigo}")
    public PostoAtendimento BuscarPAPorCdigo (@PathVariable Integer codigo) {
        return postoAtendimentoService.buscarPAPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public String atualizarPA (@PathVariable Integer codigo, @RequestBody PostoAtendimento postoAtendimento) {
        Boolean atualizou = postoAtendimentoService.atualizarAgencia(codigo, postoAtendimento);
        if(!atualizou){
            return "Posto de Atendimento não encontrado.";
        }
        return "Posto de atendimento atualizado com sucesso.";
    }

    @DeleteMapping ("/{codigo}")
    public String deletarPA (@PathVariable Integer codigo) {
        Boolean deletou = postoAtendimentoService.deletarPA(codigo);
        if (!deletou){
            return "Posto de Atendimento não encontrado.";
        }
        return "Posto de atendimento deletado com sucesso.";
    }

    @PostMapping
    public String cadastrarPA (@RequestBody PostoAtendimento postoAtendimento) {
        if (postoAtendimento.getTelefone() == null || postoAtendimento.getTelefone().equals("")){
            return "Telefone obrigatório.";}
        if (postoAtendimento.getAgenciaOrigem() == null){
            return "Agencia de origem obrigatório.";}
        postoAtendimentoService.adicionarPA(postoAtendimento);
        return "Posto de atendimento cadastrado com sucesso.";
    }
}
