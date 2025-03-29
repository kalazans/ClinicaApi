package com.Clinicia.Clinica.service.validacoes;

import com.Clinicia.Clinica.dto.ConsultaDTO;
import com.Clinicia.Clinica.infra.exceptions.ValidacaoMedicoConsultaNoDiaException;
import com.Clinicia.Clinica.model.Consulta;
import com.Clinicia.Clinica.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ValidacaoMedicoConsultaNoDia implements Validador{
    @Autowired
    ConsultaRepository consultaRepository;
    @Override
    public void validar(ConsultaDTO consultaDTO) {
        LocalDate data  = LocalDate.parse(consultaDTO.data(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Optional<Consulta> consulta = consultaRepository.findByIdMedicoAndDateConsultaEquals(consultaDTO.medicoId(),data);
        if(consulta.isPresent()){
            throw new ValidacaoMedicoConsultaNoDiaException("medico ja tem consulta neste dia");
        }

    }
}
