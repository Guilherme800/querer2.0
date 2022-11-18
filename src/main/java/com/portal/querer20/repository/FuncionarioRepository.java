package com.portal.querer20.repository;

import com.portal.querer20.model.Agencia;
import com.portal.querer20.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Funcionario findByFuncional (Integer funcional);
    List<Funcionario> findByNome (String nome);
    Funcionario findByEmail (String email);
    Funcionario findByCargo (String cargo);

}
