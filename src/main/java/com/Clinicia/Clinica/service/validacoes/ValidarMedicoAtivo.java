package com.Clinicia.Clinica.service.validacoes;

import com.Clinicia.Clinica.dto.ConsultaDTO;
import com.Clinicia.Clinica.infra.exceptions.ValidarMedicoAtivoException;
import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarMedicoAtivo implements Validador{
    @Autowired
    MedicoRepository medicoRepository;
    @Override
    public void validar(ConsultaDTO consultaDTO) {
        Optional<Medico> medico = medicoRepository.findByIdAndAtivo(consultaDTO.medicoId(),true);
        if(medico.isEmpty()){
            throw new ValidarMedicoAtivoException("medico esta inativo");
        }
    }
}
