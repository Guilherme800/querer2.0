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
        return null;
    }

    @PutMapping("/{codigo}")
    public String atualizarPA (@PathVariable Integer codigo, @RequestBody PostoAtendimento postoAtendimento) {
        return null;
    }

    @DeleteMapping ("/{codigo}")
    public String deletarPA (@PathVariable Integer codigo) {
        return null;
    }

    @PostMapping
    public String cadastrarPA (@RequestBody PostoAtendimento postoAtendimento) {
        return null;
    }
}
