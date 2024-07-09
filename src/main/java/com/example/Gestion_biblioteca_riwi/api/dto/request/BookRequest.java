package com.example.Gestion_biblioteca_riwi.api.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "el nombre del libro es requerido")
    @Size(min = 1,max = 100)
    private String title;

    @NotBlank(message = "el nombre del autor es requerido")
    @Size(min = 1,max = 100)
    private String author;
    @NotNull(message = "el año de publicacion es requerido")
    private LocalDate publicationYear;

    private String genre;

    private String isbn;
}
