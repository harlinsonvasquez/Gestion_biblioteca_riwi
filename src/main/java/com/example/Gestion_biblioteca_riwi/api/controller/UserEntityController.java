package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IUserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserEntityController {
    @Autowired
    private final IUserEntityService userEntityService;

    @GetMapping
    public ResponseEntity<Page<UserBasicResp>> getAllUsers(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "10")int size) {
        return ResponseEntity.ok(this.userEntityService.getAll(page -1, size));

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResp>getById(@PathVariable long id) {
        Optional<UserResp> userRespOptional = userEntityService.getUserWithReservationsAndLoans(id);

        // Verifica si se encontró el usuario
        if (userRespOptional.isPresent()) {
            return ResponseEntity.ok(userRespOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserBasicResp>create(
            @Validated @RequestBody UserRequest userRequest
            ){
        return ResponseEntity.ok(this.userEntityService.create(userRequest));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserBasicResp>update(
            @PathVariable long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(this.userEntityService.update(userRequest, id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserBasicResp>delete(@PathVariable long id) {
        this.userEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
