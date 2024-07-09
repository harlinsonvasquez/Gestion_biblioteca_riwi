package com.example.Gestion_biblioteca_riwi.api.dto.request;

import com.example.Gestion_biblioteca_riwi.utils.enums.StatusReservation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    //private LocalDateTime loanDate;
    @NotNull(message = "la fecha de entrega del libro es requerida")
    private LocalDateTime returnDate;
    @NotNull(message = "el estado del libro es requerido")
    private StatusReservation status;
    @NotNull(message = "el id del libro es requerido")
    private Long bookId;
    @NotNull(message = "el id del usuario es requerido")
    private Long userId;

}
