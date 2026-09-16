package com.sistema.elos.frenquecia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, UUID> {


    List<Frequencia>findByAlunoId(UUID id);

}
