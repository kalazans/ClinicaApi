package com.Clinicia.Clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RemaracarConsultaDTO(@NotNull @NotBlank  String novaData,
                                   @NotNull @NotBlank  String dataAntiga) {
}
