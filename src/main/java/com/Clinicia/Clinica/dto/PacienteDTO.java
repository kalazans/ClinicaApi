package com.Clinicia.Clinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(@NotNull @NotBlank @Pattern(regexp = "([a-zA-z])+") String firstName,
                          @NotNull @NotBlank @Pattern(regexp = "([a-zA-z])+")String lastName,
                          @NotNull @NotBlank @Email String email,
                          @NotNull @NotBlank @Pattern(regexp = "\\d{11}") String cpf) {
}
