package com.portal.querer20.service;

import com.portal.querer20.model.Localidade;
import com.portal.querer20.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public List<Localidade> listarLocalidades () {
        return localidadeRepository.findAll();
    }

    public Localidade cadastrarLocalidade (Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public Boolean atualizarLocalidade (Integer id, Localidade localidade){
        Localidade localidadedb = buscarLocalidadePorId(id);
        if(localidade == null){
            return false;
        }

        if (localidade.getBairro() != null){
            localidadedb.setBairro(localidade.getBairro());
        }
        if (localidade.getCidade() != null){
            localidadedb.setCidade(localidade.getCidade());
        }
        if (localidade.getLogradouro() != null){
            localidadedb.setLogradouro(localidade.getLogradouro());
        }
        if (localidade.getEstado() != null){
            localidadedb.setEstado(localidade.getEstado());
        }
        localidadeRepository.save(localidadedb);
        return true;
    }

    public Boolean deletarLocalidade (Integer id){
        Localidade localidade = buscarLocalidadePorId(id);
        if(localidade == null){
            return false;
        }
        localidadeRepository.delete(localidade);
        return true;
    }

    public Localidade buscarLocalidadePorId(Integer id){
        return localidadeRepository.findById(id).get();
    }

}
