package com.Clinicia.Clinica.repository;

import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findByIdAndAtivo(Long id, boolean ativo);
}
