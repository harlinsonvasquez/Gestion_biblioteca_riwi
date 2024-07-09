package com.example.Gestion_biblioteca_riwi.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookBasicResp {

    private Long id;
    private String title;
    private String author;
    private LocalDate publicationYear;
    private String genre;
    private String isbn;
}
