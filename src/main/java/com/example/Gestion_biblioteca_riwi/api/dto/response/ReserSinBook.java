package com.example.Gestion_biblioteca_riwi.api.dto.response;

import com.example.Gestion_biblioteca_riwi.utils.enums.StatusReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserSinBook {
    private Long id;
    private LocalDateTime reservationDate;
    private StatusReservation status;
    private UserBasicResp userEntity;
}
