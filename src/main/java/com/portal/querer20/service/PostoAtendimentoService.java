package com.portal.querer20.service;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.model.Funcionario;
import com.portal.querer20.model.PostoAtendimento;
import com.portal.querer20.repository.FuncionarioRepository;
import com.portal.querer20.repository.PostoAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostoAtendimentoService {

    @Autowired
    private PostoAtendimentoRepository postoAtendimentoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<PostoAtendimento> listarPA (){
        return postoAtendimentoRepository.findAll();
    }

    public PostoAtendimento buscarPAPorCodigo (Integer codigo) {
        return postoAtendimentoRepository.findByCodigo(codigo);
    }

    public Boolean atualizarAgencia (Integer codigo, PostoAtendimento postoAtendimento) {
        PostoAtendimento postoAtendimento1 = postoAtendimentoRepository.findByCodigo(codigo);
        if (postoAtendimento1 !=null) {
            if (postoAtendimento.getFuncionarios() != null){
                postoAtendimento1.setFuncionarios(postoAtendimento.getFuncionarios());}
            if (postoAtendimento.getCodigo() != null){
                postoAtendimento1.setCodigo(postoAtendimento.getCodigo());}
            if (postoAtendimento.getLocalidade() != null){
                postoAtendimento1.setLocalidade(postoAtendimento.getLocalidade());}
            if (postoAtendimento.getAgencia() != null){
                postoAtendimento1.setAgencia(postoAtendimento.getAgencia());}
            if (postoAtendimento.getTelefone() != null){
                postoAtendimento1.setTelefone(postoAtendimento.getTelefone());}
            postoAtendimentoRepository.save(postoAtendimento1);
            return true;
        }
        return false;
    }

    public Boolean deletarPA (Integer codigo) {
        PostoAtendimento postoAtendimento = postoAtendimentoRepository.findByCodigo(codigo);
        if (postoAtendimento == null) {
            return false;
        }
        postoAtendimentoRepository.delete(postoAtendimento);
        return true;
    }

    public void adicionarPA (PostoAtendimento postoAtendimento) {
        List<Funcionario> funcionarios1 = new ArrayList<>();
        for (Funcionario funcionario : postoAtendimento.getFuncionarios()) {
            Funcionario funcionario1;
            if (funcionarioRepository.findByFuncional(funcionario.getFuncional()) != null) {
                funcionario1 = funcionarioRepository.findByFuncional(funcionario.getFuncional());
            } else {
                funcionario1 = funcionario;
            }
            funcionario1.setpA(postoAtendimento);
            funcionarioRepository.save(funcionario1);
            funcionarios1.add(funcionario1);
        }

        postoAtendimentoRepository.save(postoAtendimento);
    }

}
