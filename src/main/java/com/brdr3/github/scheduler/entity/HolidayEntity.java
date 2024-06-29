package com.brdr3.github.scheduler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
@Table(name = "feriados")
public class HolidayEntity {
    @Id
    @Column(name = "id_feriado", nullable = false)
    private UUID idFeriado;

    @Column(name = "data_feriado")
    private LocalDate dataFeriado;
}
