package com.example.Gestion_biblioteca_riwi.api.dto.response;

import com.example.Gestion_biblioteca_riwi.utils.enums.StatusLoan;
import com.example.Gestion_biblioteca_riwi.utils.enums.StatusReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanBasicResp {

    private Long id;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private StatusLoan status;
    private BookBasicResp book;

}
