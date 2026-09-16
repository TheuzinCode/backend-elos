package com.sistema.elos.historicoaluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface HistoricoAlunoRepository extends JpaRepository<HistoricoAluno, UUID> {

    List<HistoricoAluno> findByAlunoId(UUID id);
}
