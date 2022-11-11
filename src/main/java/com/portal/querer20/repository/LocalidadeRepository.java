package com.portal.querer20.repository;

import com.portal.querer20.model.Funcionario;
import com.portal.querer20.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {

    Localidade findByBairro (String bairro);
    Localidade findByCidade (String cidade);
    Localidade findByEstado (String estado);
    Localidade findByLogradouro (String logradouro);

}
