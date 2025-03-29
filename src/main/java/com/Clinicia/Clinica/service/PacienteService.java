package com.Clinicia.Clinica.service;

import com.Clinicia.Clinica.dto.PacienteDadosDTO;
import com.Clinicia.Clinica.model.Paciente;
import com.Clinicia.Clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public void salvarDB(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public Paciente acharPorIdDB(Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        return paciente;

    }

    public List<Paciente> listaDB(){
        return  pacienteRepository.findAll();
    }

    public boolean idExiste(Long id){
        return pacienteRepository.existsById(id);

    }
}
