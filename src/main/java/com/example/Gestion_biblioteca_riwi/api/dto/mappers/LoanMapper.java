package com.example.Gestion_biblioteca_riwi.api.dto.mappers;

import com.example.Gestion_biblioteca_riwi.api.dto.request.LoanRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanRespSinBook;
import com.example.Gestion_biblioteca_riwi.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses=UserMapper.class)
public interface LoanMapper {
    @Mappings({
            @Mapping(target = "user.id",source = "loanRequest.userId"),
            @Mapping(target = "book.id",source ="loanRequest.bookId" )
    })
    Loan requestToEntity(LoanRequest loanRequest);

    @Mapping(target = "book",source = "loan.book")
    @Named("entityToBasicResponse")
    LoanBasicResp entityToBasicResponse(Loan loan);

    @Mapping(target = "book",source = "loan.book")
    @Mapping(target = "user",source = "loan.user")
    @Named("entityToLoanResp")
    LoanResp entityToLoanResp(Loan loan);

    @Mapping(target = "userEntity",source = "loan.user")
    @Named("entityToLoanRespSinBook")
    LoanRespSinBook entityToLoanRespSinBook(Loan loan);


    List<LoanResp> listEntityLoanResp(List<Loan> loans);



}
