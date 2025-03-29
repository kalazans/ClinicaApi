package com.Clinicia.Clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarInfoMedicoDTO(@NotBlank @NotNull @Email String email,
                                     @NotBlank @NotNull AdressDTO adressDTO) {
}
