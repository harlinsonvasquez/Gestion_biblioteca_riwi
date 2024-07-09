package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;

import java.util.Optional;

public interface IUserEntityService extends CrudService<UserRequest, UserBasicResp,Long>{
    Optional<UserResp> getUserWithReservationsAndLoans(Long id);
}
