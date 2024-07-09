package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.UserMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import com.example.Gestion_biblioteca_riwi.domain.repositories.UserEntityRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IUserEntityService;
import com.example.Gestion_biblioteca_riwi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserBasicResp update(UserRequest request, Long id) {
        UserEntity userEntity =find(id);
        userMapper.updateUserFromRequest(request,userEntity);
        userEntity = userEntityRepository.save(userEntity);

        return userMapper.entityToBasicResp(userEntity);
    }

    @Override
    public UserBasicResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity=find(id);
        userEntityRepository.delete(userEntity);
    }

    @Override
    public Page<UserBasicResp> getAll(int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<UserEntity> userEntityPage=userEntityRepository.findAll(pageRequest);

        return userEntityPage.map(userMapper::entityToBasicResp);
    }
    private UserEntity find(Long id) {
        return userEntityRepository.findById(id).orElseThrow(()-> new IdNotFoundException("user"));
    }

    @Override
    public Optional<UserResp> getUserWithReservationsAndLoans(Long id) {
        Optional<UserEntity> userEntityOptional = userEntityRepository.findById(id);

        // Verifica si el usuario existe antes de mapearlo
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return Optional.of(userMapper.entityToResp(userEntity));
        } else {
            return Optional.empty();
        }
    }
}
