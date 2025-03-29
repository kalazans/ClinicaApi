package com.Clinicia.Clinica.dto;

import com.Clinicia.Clinica.model.Paciente;

public record PacienteDadosDTO(String firstName, String lastName, String email) {
    public PacienteDadosDTO(Paciente paciente){
        this(paciente.getFirstName(), paciente.getLastName(), paciente.getEmail());
    }

}
