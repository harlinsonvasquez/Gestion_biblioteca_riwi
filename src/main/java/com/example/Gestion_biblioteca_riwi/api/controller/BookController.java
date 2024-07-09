package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    @Autowired
    private final IBookService bookService;

    @PostMapping
    public ResponseEntity<BookBasicResp>create(
            @Validated @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(this.bookService.create(bookRequest));
    }
}
