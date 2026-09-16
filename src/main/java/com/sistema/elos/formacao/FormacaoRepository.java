package com.sistema.elos.formacao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacaoRepository extends JpaRepository<Formacao, UUID> {
}
