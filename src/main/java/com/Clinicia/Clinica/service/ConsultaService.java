package com.Clinicia.Clinica.service;

import com.Clinicia.Clinica.dto.ConsultaDTO;
import com.Clinicia.Clinica.dto.RemaracarConsultaDTO;
import com.Clinicia.Clinica.model.Consulta;
import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.model.Paciente;
import com.Clinicia.Clinica.repository.ConsultaRepository;
import com.Clinicia.Clinica.service.validacoes.Validador;
import com.Clinicia.Clinica.service.validacoes.ValidarRemarcarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    MedicoService medicoService;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    ConsultaRepository consultaRepository;
    @Autowired
    List<Validador> validacoes;
    @Autowired
    ValidarRemarcarConsulta validarRemarcarConsulta;

    public Consulta marcarConsultaDB(ConsultaDTO consultaDTO){
       validacoes.forEach(v->v.validar(consultaDTO));
        Paciente paciente = pacienteService.acharPorIdDB(consultaDTO.pacienteId());
        Medico medico = medicoService.acharPorIdDB(consultaDTO.medicoId());
        Consulta consulta =  new Consulta(paciente,medico,consultaDTO.data());
        consultaRepository.save(consulta);
        return  consulta;
    }

    public Consulta remacarConsultaDB(RemaracarConsultaDTO remaracarConsultaDTO,Long pacienteId){
        validarRemarcarConsulta.validarRemaracar(remaracarConsultaDTO,pacienteId);
        Consulta consulta = consultaRepository.getReferenceById(pacienteId);
        consulta.atualizarConsulta(remaracarConsultaDTO);
        consultaRepository.save(consulta);
        return consulta;
    }

    public List<Consulta> listaConsultaPacienteDB(Long id){
        return consultaRepository.findAllByIdPaciente(id);
    }
    public List<Consulta> listaConsultaMedicoDB(Long id){
        return consultaRepository.findAllByIdMedico(id);
    }


}
