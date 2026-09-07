package com.sistema.elos.responsavel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRespository extends JpaRepository<Responsavel, Long> {


}
