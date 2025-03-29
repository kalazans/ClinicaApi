package com.Clinicia.Clinica.repository;

import com.Clinicia.Clinica.model.Consulta;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Optional<Consulta> findByIdPaciente(Long pacienteId);
    Optional<Consulta> findByIdMedico(Long medicoeId);
    List<Consulta>  findAllByIdPaciente(Long id);
    List<Consulta>  findAllByIdMedico(Long id);
    Consulta findByDateConsultaEqualsAndIdPaciente(LocalDate dataAntiga, Long pacienteId);
    Optional<Consulta> findByIdMedicoAndDateConsultaEquals(Long idMedico,LocalDate consulta);
    Optional<Consulta> findByIdPacienteAndDateConsultaEquals(Long idPaciente, LocalDate data);
}
