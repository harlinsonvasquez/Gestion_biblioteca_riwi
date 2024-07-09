package com.example.Gestion_biblioteca_riwi.api.dto.mappers;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity requestToEntity(UserRequest request);

    @Named("entityToBasicResp")
    UserBasicResp entityToBasicResp(UserEntity userEntity);

    @Mapping(target = "reservations",source = "userEntity.reservationList")
    @Mapping(target = "loans",source = "userEntity.loanList")
    @Named("entityToResp")
    UserResp entityToResp(UserEntity userEntity);

    List<UserBasicResp> listEntityToBasicResp(List<UserEntity> userEntities);
    List<UserResp> listEntityToResp(List<UserEntity> userEntities);
}
