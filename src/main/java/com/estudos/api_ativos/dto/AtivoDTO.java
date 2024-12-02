package com.estudos.api_ativos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class AtivoDTO {
    UUID id;

    @NotBlank(message = "The manufacturer name is mandatory.")
    private String manufacturer;

    @NotNull(message = "The Update Date cannot be null")
    private LocalDate dateUpdate;

    @NotBlank(message = "The department name is mandatory.")
    private String department;

    @NotBlank(message = "The serial number is mandatory.")
    private String serialNumber;

    @NotBlank(message = "The asset number is mandatory.")
    private String assetNumber;
}


