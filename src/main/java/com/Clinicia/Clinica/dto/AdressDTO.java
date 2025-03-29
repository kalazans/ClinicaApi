package com.Clinicia.Clinica.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Valid
public record AdressDTO(
            @NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String cidade,
          @NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String bairro,
          @NotBlank @NotNull @Pattern(regexp = "([a-zA-z])+") String estado) {
}
