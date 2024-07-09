package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.BookMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import com.example.Gestion_biblioteca_riwi.domain.repositories.BookRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public BookBasicResp create(BookRequest request) {
        Book book=bookMapper.requestToBook(request);
        Book savedBook=bookRepository.save(book);
        return bookMapper.entityToBasicResp(savedBook);
    }

    @Override
    public BookResp update(BookRequest request, Long aLong) {
        return null;
    }

    @Override
    public BookResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<BookBasicResp> getAll(int page, int size) {
        return null;
    }
}
