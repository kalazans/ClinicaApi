package com.Clinicia.Clinica.controller;


import com.Clinicia.Clinica.dto.PacienteDTO;
import com.Clinicia.Clinica.infra.exceptions.ParametroVazioException;
import com.Clinicia.Clinica.model.Consulta;
import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.model.Paciente;
import com.Clinicia.Clinica.repository.ConsultaRepository;
import com.Clinicia.Clinica.service.MedicoService;
import com.Clinicia.Clinica.service.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/paciente")
public class ControllerPaciente {
    @Autowired
    PacienteService pacienteService;
    @Autowired
    MedicoService medicoService;
   @Autowired
    ConsultaRepository consultaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uri){
        Paciente paciente = new Paciente(pacienteDTO);
        pacienteService.salvarDB(paciente);
        URI link = uri.path("/paciente/{id}").buildAndExpand(paciente).toUri();
        return ResponseEntity.created(link).body(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity acharPorId(@PathVariable Optional<Long> id){
        if(id.isEmpty()){
            throw new ParametroVazioException("parametro {pacienteId} esta vazio");
        }
        return  ResponseEntity.ok(pacienteService.acharPorIdDB(id.get()));
    }

    @GetMapping("/lista")
    public ResponseEntity lista(){
        return ResponseEntity.ok(pacienteService.listaDB());
    }



}
