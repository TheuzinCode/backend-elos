package com.sistema.elos.responsavel;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRespository extends JpaRepository<Responsavel, UUID> {


}
