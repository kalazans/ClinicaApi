package com.Clinicia.Clinica.repository;

import com.Clinicia.Clinica.model.ESPECIALIDADE;
import com.Clinicia.Clinica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
    List<Medico> findByEspecialidade(ESPECIALIDADE especialidade);

    Optional<Medico> findByIdAndAtivo(Long id, boolean ativo);
}
