package com.Clinicia.Clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ConsultaDTO(@NotNull Long pacienteId,
                          @NotNull Long medicoId,
                          @NotNull @NotBlank String data) {
}
