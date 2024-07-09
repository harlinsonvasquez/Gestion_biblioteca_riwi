package com.example.Gestion_biblioteca_riwi.api.controller;

import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    @Autowired
    private final IBookService bookService;


    @GetMapping
    public ResponseEntity<Page<BookBasicResp>> getAllBooks(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "10")int size) {
        return ResponseEntity.ok(this.bookService.getAll(page -1, size));

    }

    @PostMapping
    public ResponseEntity<BookBasicResp>create(
            @Validated @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(this.bookService.create(bookRequest));
    }
}
