package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import com.example.Gestion_biblioteca_riwi.api.dto.request.LoanRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.LoanResp;

public interface ILoanService extends CrudService<LoanRequest, LoanResp,Long>{
}
