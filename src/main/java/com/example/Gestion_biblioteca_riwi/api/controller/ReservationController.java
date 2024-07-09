package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.ReservationRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    @Autowired
    private final IReservationService reservationService;

    @GetMapping
    public ResponseEntity<Page<ReservationResp>> getAllReservations(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "10")int size) {
        return ResponseEntity.ok(this.reservationService.getAll(page -1, size));

    }

    @PostMapping
    public ResponseEntity<ReservationResp>create(
            @Validated @RequestBody ReservationRequest reservationRequest
            ){
        return ResponseEntity.ok(this.reservationService.create(reservationRequest));
    }
}
