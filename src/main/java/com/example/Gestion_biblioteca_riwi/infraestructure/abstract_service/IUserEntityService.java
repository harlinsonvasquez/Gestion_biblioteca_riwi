package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import com.example.Gestion_biblioteca_riwi.api.dto.request.UserRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.UserBasicResp;

public interface IUserEntityService extends CrudService<UserRequest, UserBasicResp,Long>{

}
