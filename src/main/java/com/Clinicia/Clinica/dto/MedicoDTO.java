package com.Clinicia.Clinica.dto;


import com.Clinicia.Clinica.model.ESPECIALIDADE;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(@NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String firstName,
                        @NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String lastName,
                        @NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String especialidade,
                         @NotNull @Valid AdressDTO adress,
                        @NotBlank @NotNull @Email String email,
                        @NotBlank @NotNull @Pattern(regexp = "\\d{4,6}") String crm) {
    public MedicoDTO{
        ESPECIALIDADE.valueOf(especialidade.toUpperCase());
    }
}
