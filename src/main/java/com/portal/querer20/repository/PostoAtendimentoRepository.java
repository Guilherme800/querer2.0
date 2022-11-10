package com.portal.querer20.repository;

import com.portal.querer20.model.PostoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoAtendimentoRepository extends JpaRepository<PostoAtendimento, Integer> {
}
