package com.portal.querer20.controller;

import com.portal.querer20.model.Funcionario;
import com.portal.querer20.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionario (){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping ("/{nome}")
    public List<Funcionario> listarPorNome (@PathVariable String nome){

        return funcionarioService.buscarPorNome(nome);
    }

    @GetMapping("/funcionario/{funcional}")
    public Funcionario buscarPorFuncional (@PathVariable Integer funcional){

        return funcionarioService.buscarPorFuncional(funcional);
    }

    @PostMapping
    public String adicionarFuncionario (@RequestBody Funcionario funcionario){
        if (funcionario.getTelefoneCelular() == null || funcionario.getTelefoneCelular().equals("")){
            return "Telefone obrigatório.";}
        if (funcionario.getFuncional() == null){
            return "Funcional obrigatório.";}
        if (funcionario.getNome() == null || funcionario.getNome().equals("")){
            return "Nome obrigatório.";}
        if (funcionario.getEmail() == null || funcionario.getEmail().equals("")){
            return "Email obrigatório.";}
        if (funcionario.getCargo() == null || funcionario.getCargo().equals("")){
            return "Cargo obrigatório.";}

        funcionarioService.adicionarFuncionario(funcionario);
        return "Funcionario adicionado.";
    }

    @DeleteMapping("/{funcional}")
    public String excluirFuncionario (@PathVariable Integer funcional) {
        Boolean atualizou = funcionarioService.excluirFuncionario(funcional);
        if(!atualizou) {
            return "Funcionario não encontrado.";
        }
        return "Funcionario excluido com sucesso.";
    }

    @PutMapping("/{funcional}")
    public String atualizarfuncionario (@PathVariable Integer funcional,@RequestBody Funcionario funcionario) {
        Boolean atualizou = funcionarioService.atualizarFuncionario(funcional, funcionario);
        if(!atualizou){
            return "Funcionario não encontrado.";
        }
        return "Funcionario atualizado com sucesso.";
    }
}
