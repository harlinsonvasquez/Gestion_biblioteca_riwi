package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IUserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserEntityController {
    @Autowired
    private final IUserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<UserBasicResp>create(
            @Validated @RequestBody UserRequest userRequest
            ){
        return ResponseEntity.ok(this.userEntityService.create(userRequest));
    }
}
