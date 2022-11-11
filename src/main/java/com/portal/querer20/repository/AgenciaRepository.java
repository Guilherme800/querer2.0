package com.portal.querer20.repository;

import com.portal.querer20.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {

    Agencia findByCodigo (Integer codigo);

}
