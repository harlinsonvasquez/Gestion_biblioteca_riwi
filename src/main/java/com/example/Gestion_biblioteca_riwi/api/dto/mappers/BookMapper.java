package com.example.Gestion_biblioteca_riwi.api.dto.mappers;

import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    Book requestToBook(BookRequest bookRequest);

    @Named("entityToBasicResp")
    BookBasicResp entityToBasicResp(Book book);

    @Mapping(target = "loans",source = "book.loanList")
    @Mapping(target = "reservas",source = "book.reservationList")
    @Named("entityToBookResp")
    BookResp entityToBookResp(Book book);

    List<BookBasicResp> listEntityToBasicResp(List<Book> bookList);

}
