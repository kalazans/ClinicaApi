package com.Clinicia.Clinica.controller;

import com.Clinicia.Clinica.dto.ConsultaDTO;
import com.Clinicia.Clinica.dto.RemaracarConsultaDTO;
import com.Clinicia.Clinica.infra.exceptions.ParametroVazioException;
import com.Clinicia.Clinica.model.Consulta;

import com.Clinicia.Clinica.service.ConsultaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/consulta")
public class ControllerConsulta {
    @Autowired
    ConsultaService consultaService;
    @PostMapping
    @Transactional
    public ResponseEntity marcaConsulta(@RequestBody @Valid  ConsultaDTO consultaDTO, UriComponentsBuilder uri){
        Consulta consulta = consultaService.marcarConsultaDB(consultaDTO);
        URI link = uri.path("/consulta/{id}").buildAndExpand(consulta).toUri();
        return ResponseEntity.created(link).body(consulta);
    }

    @GetMapping("lista/paciente/{pacienteId}")
    public ResponseEntity listaConsultaPaciente(@PathVariable Optional<Long> pacienteId){
        if(pacienteId.isEmpty()){
             throw new ParametroVazioException("parametro {pacienteId} esta vazio");
        }
        return ResponseEntity.ok(consultaService.listaConsultaPacienteDB(pacienteId.get()));
    }

    @GetMapping("lista/medico/{medicoId}")
    public ResponseEntity listaConsultaMedico(@PathVariable Optional<Long> medicoId){
        if(medicoId.isEmpty()){
            throw new ParametroVazioException("parametro {medicoId} esta vazio");
        }
        return ResponseEntity.ok(consultaService.listaConsultaMedicoDB(medicoId.get()));
    }

    @PutMapping("/remarcar/{pacienteId}")
    @Transactional
    public ResponseEntity remarcarConsulta(@RequestBody @Valid RemaracarConsultaDTO remarcar,@PathVariable Optional<Long> pacienteId){
        if(pacienteId.isEmpty()){
            throw new ParametroVazioException("parametro {pacienteId} esta vazio");
        }
        return ResponseEntity.accepted().body(consultaService.remacarConsultaDB(remarcar,pacienteId.get()));
    }






}
