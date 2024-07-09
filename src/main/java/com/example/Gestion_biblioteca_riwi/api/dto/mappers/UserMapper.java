package com.example.Gestion_biblioteca_riwi.api.dto.mappers;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Loan;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {LoanMapper.class})
public interface UserMapper {
    UserEntity requestToEntity(UserRequest request);

    @Named("entityToBasicResp")
    UserBasicResp entityToBasicResp(UserEntity userEntity);

    @Mapping(target = "reservations",source = "userEntity.reservationList")
    @Mapping(target = "loans",source = "userEntity.loanList")
                                                                                                                                                                                            @Named("entityToResp")
    UserResp entityToResp(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)// Ignora la asignación de ID
    void updateUserFromRequest(UserRequest request, @MappingTarget UserEntity userEntity);




    List<UserBasicResp> listEntityToBasicResp(List<UserEntity> userEntities);
    List<UserResp> listEntityToResp(List<UserEntity> userEntities);
}
