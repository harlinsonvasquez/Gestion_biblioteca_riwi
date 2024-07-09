package com.example.Gestion_biblioteca_riwi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookResp extends BookBasicResp{
    private List<LoanRespSinBook> loans;
    private List<ReserSinBook> reservas;
}
