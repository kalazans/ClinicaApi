package com.Clinicia.Clinica.service.validacoes;

import com.Clinicia.Clinica.dto.RemaracarConsultaDTO;
import com.Clinicia.Clinica.model.Consulta;
import com.Clinicia.Clinica.model.Paciente;
import com.Clinicia.Clinica.repository.ConsultaRepository;
import com.Clinicia.Clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ValidarRemarcarConsulta {
    @Autowired
    ConsultaRepository consultaRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    public void validarRemaracar(RemaracarConsultaDTO remarcar,Long idPaciente){
        Optional<Paciente> paciente = pacienteRepository.findByIdAndAtivo(idPaciente,true);
        LocalDate dataNova = LocalDate.parse(remarcar.novaData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Optional<Consulta> consulta = consultaRepository.findByIdPacienteAndDateConsultaEquals(idPaciente,dataNova);
        if(paciente.isEmpty()){
            throw  new RuntimeException("paciente inativo");
        }
        if(consulta.isPresent()){
            throw new RuntimeException("Paciente ja tem consulta no dia");
        }
    }
}
