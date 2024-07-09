package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.BookMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import com.example.Gestion_biblioteca_riwi.domain.repositories.BookRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IBookService;
import com.example.Gestion_biblioteca_riwi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public BookResp update(BookRequest request, Long id) {
        Book book=find(id);
        bookMapper.updateBookFromRequest(request,book);
        Book savedBook=bookRepository.save(book);
        return bookMapper.entityToBookResp(savedBook);
    }

    @Override
    public BookResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Book book=find(id);
        bookRepository.delete(book);
    }

    @Override
    public Page<BookBasicResp> getAll(int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Book> books=bookRepository.findAll(pageRequest);
        return books.map(bookMapper::entityToBasicResp);
    }
    private Book find(Long id){
        return bookRepository.findById(id).orElseThrow(()->new IdNotFoundException("Book not found"));
    }
}
