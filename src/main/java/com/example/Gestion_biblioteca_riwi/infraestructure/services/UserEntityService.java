package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.UserMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import com.example.Gestion_biblioteca_riwi.domain.repositories.UserEntityRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IUserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserEntityService implements IUserEntityService {

    @Autowired
    private final UserEntityRepository userEntityRepository;
    @Autowired
    private  final UserMapper userMapper;

    @Override
    public UserBasicResp create(UserRequest request) {
        UserEntity userEntity =userMapper.requestToEntity(request);
        userEntity = userEntityRepository.save(userEntity);
        return userMapper.entityToBasicResp(userEntity);
    }

    @Override
    public UserBasicResp update(UserRequest request, Long aLong) {
        return null;
    }

    @Override
    public UserBasicResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<UserBasicResp> getAll(int page, int size) {
        return null;
    }
}
