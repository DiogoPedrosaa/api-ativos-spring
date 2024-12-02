package com.estudos.api_ativos.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ativos")
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "The manufacturer name is mandatory.")
    private String manufacturer;

    @NotNull(message = "The Update Date cannot be null")
    private LocalDate dateUpdate;

    @NotBlank(message = "The department name is mandatory.")
    private String department;

    @NotBlank(message = "The serial number is mandatory.")
    @Column(unique = true)
    private String serialNumber;

    @NotBlank(message = "The asset number is mandatory.")
    @Column(unique = true)
    private String assetNumber;
}
