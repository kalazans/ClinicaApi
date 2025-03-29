package com.Clinicia.Clinica.controller;

import com.Clinicia.Clinica.dto.AtualizarInfoMedicoDTO;
import com.Clinicia.Clinica.dto.MedicoDTO;
import com.Clinicia.Clinica.infra.exceptions.ParametroVazioException;
import com.Clinicia.Clinica.model.ESPECIALIDADE;
import com.Clinicia.Clinica.model.Medico;
import com.Clinicia.Clinica.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class ControllerMedico {
    @Autowired
    MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uri){
        Medico medico = new Medico(medicoDTO);
        medicoService.salvarDB(medico);
        URI url =uri.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(medico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarInfoMedicoDTO atualizarInfoMedicoDTO,@PathVariable Optional<Long> id){
        if(id.isEmpty()){
            throw new ParametroVazioException("parametro {id} esta vazio");
        }
        return ResponseEntity.accepted().body(medicoService.atualizarDB(id.get(),atualizarInfoMedicoDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity medicoPorId(@PathVariable Optional<Long> id){
        if(id.isEmpty()){
            throw new ParametroVazioException("parametro {id} esta vazio");
        }
        return ResponseEntity.ok(medicoService.acharPorIdDB(id.get()));
    }
    @GetMapping("/lista")
    public ResponseEntity lista(){
        return ResponseEntity.ok(medicoService.listaDB());
    }

    @GetMapping("/lista/busca?especialidade")
    public ResponseEntity listaPorEspecialidade(@RequestParam Optional<String> especialidade){
        if(especialidade.isEmpty()){
            throw new ParametroVazioException("parametro {especialidade} esta vazio");
        }
        ESPECIALIDADE esp = ESPECIALIDADE.valueOf(especialidade.get().toUpperCase());
        return ResponseEntity.ok(medicoService.listaPorEspecialidadeDB(esp));
    }



}
