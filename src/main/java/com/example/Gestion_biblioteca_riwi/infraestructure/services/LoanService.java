package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.LoanMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.LoanRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import com.example.Gestion_biblioteca_riwi.domain.entities.Loan;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import com.example.Gestion_biblioteca_riwi.domain.repositories.BookRepository;
import com.example.Gestion_biblioteca_riwi.domain.repositories.LoanRepository;
import com.example.Gestion_biblioteca_riwi.domain.repositories.UserEntityRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.ILoanService;
import com.example.Gestion_biblioteca_riwi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoanService  implements ILoanService {
    @Autowired
    private  final UserEntityRepository UserEntityRepository;
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final LoanRepository loanRepository;
    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public LoanResp create(LoanRequest request) {
        UserEntity userEntity=UserEntityRepository.findById(request.getUserId()).orElseThrow(()-> new IdNotFoundException("user"));
        Book book=bookRepository.findById(request.getBookId()).orElseThrow(()-> new IdNotFoundException("book"));

        Loan loan=loanMapper.requestToEntity(request);
        loan.setUser(userEntity);
        loan.setBook(book);

        Loan loansave=loanRepository.save(loan);
        return loanMapper.entityToLoanResp(loansave);
    }

    @Override
    public LoanResp update(LoanRequest request, Long aLong) {
        return null;
    }

    @Override
    public LoanResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<LoanResp> getAll(int page, int size) {
        return null;
    }
}
