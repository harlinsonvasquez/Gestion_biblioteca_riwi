package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import com.example.Gestion_biblioteca_riwi.api.dto.request.BookRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.BookResp;

public interface IBookService extends CrudService<BookRequest, BookBasicResp,Long>{
}
