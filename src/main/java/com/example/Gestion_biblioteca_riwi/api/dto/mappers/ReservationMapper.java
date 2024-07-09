package com.example.Gestion_biblioteca_riwi.api.dto.mappers;

import com.example.Gestion_biblioteca_riwi.api.dto.request.ReservationRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReserSinBook;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationBasicResp;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Reservation;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses= UserMapper.class)
public interface ReservationMapper {
    @Mappings({
            @Mapping(target = "user.id",source = "reservationRequest.userId"),
            @Mapping(target = "book.id",source ="reservationRequest.bookId" )
    })
    Reservation requestToReservation(ReservationRequest reservationRequest);

    @Mapping(target = "book",source = "reservation.book")
    @Named("entityToBasicResp")
    ReservationBasicResp entityToBasicResp(Reservation reservation);

    @Mapping(target = "userEntity",source = "reservation.user")
    @Mapping(target ="book",source="reservation.book" )
    @Named("entityToReservationResp")
    ReservationResp entityToReservationResp(Reservation reservation);

    @Mapping(target = "userEntity",source = "reservation.user")
    @Named("entityToReserSinBook")
    ReserSinBook entityToReserSinBook(Reservation reservation);


    List<ReservationResp>ListReservationResp(List<Reservation> reservations);

}
