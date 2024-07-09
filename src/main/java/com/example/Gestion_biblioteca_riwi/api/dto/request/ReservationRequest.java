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
public class ReservationRequest {
    @NotNull(message = "la fecha de reservacion es requerida")
    private LocalDateTime reservationDate;
    @NotNull(message = "el estado de la reservacion es requerido")
    private StatusReservation status;
    private Long bookId;
    private Long userId;
}
