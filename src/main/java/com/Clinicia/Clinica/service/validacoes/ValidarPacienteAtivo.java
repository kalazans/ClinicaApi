package com.Clinicia.Clinica.service.validacoes;

import com.Clinicia.Clinica.dto.ConsultaDTO;
import com.Clinicia.Clinica.infra.exceptions.ValidarPacienteAtivoException;
import com.Clinicia.Clinica.model.Paciente;
import com.Clinicia.Clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarPacienteAtivo implements Validador{
    @Autowired
    PacienteRepository pacienteRepository;
    @Override
    public void validar(ConsultaDTO consultaDTO) {
        Optional<Paciente> paciente = pacienteRepository.findByIdAndAtivo(consultaDTO.pacienteId(), true);
        if(paciente.isEmpty()){
            throw new ValidarPacienteAtivoException("paciente inativo");
        }

    }
}
