package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import com.example.Gestion_biblioteca_riwi.api.dto.request.ReservationRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;

public interface IReservationService extends CrudService<ReservationRequest, ReservationResp,Long>{
}
