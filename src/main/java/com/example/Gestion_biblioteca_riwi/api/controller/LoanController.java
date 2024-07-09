package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.LoanRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.request.ReservationRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanController {
    @Autowired
    private final ILoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResp> create(
            @Validated @RequestBody LoanRequest loanRequest
            ){
        return ResponseEntity.ok(this.loanService.create(loanRequest));
    }
}
