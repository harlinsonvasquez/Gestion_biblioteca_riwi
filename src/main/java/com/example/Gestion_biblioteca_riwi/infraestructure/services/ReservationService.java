package com.example.Gestion_biblioteca_riwi.infraestructure.services;

import com.example.Gestion_biblioteca_riwi.api.dto.mappers.ReservationMapper;
import com.example.Gestion_biblioteca_riwi.api.dto.request.ReservationRequest;
import com.example.Gestion_biblioteca_riwi.api.dto.response.ReservationResp;
import com.example.Gestion_biblioteca_riwi.domain.entities.Book;
import com.example.Gestion_biblioteca_riwi.domain.entities.Reservation;
import com.example.Gestion_biblioteca_riwi.domain.entities.UserEntity;
import com.example.Gestion_biblioteca_riwi.domain.repositories.BookRepository;
import com.example.Gestion_biblioteca_riwi.domain.repositories.ReservationRepository;
import com.example.Gestion_biblioteca_riwi.domain.repositories.UserEntityRepository;
import com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service.IReservationService;
import com.example.Gestion_biblioteca_riwi.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private  final UserEntityRepository UserEntityRepository;
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final ReservationMapper reservationMapper;
    @Override
    public ReservationResp create(ReservationRequest request) {
        UserEntity userEntity=UserEntityRepository.findById(request.getUserId()).orElseThrow(()-> new IdNotFoundException("user"));
        Book book=bookRepository.findById(request.getBookId()).orElseThrow(()-> new IdNotFoundException("book"));

        Reservation reservation=reservationMapper.requestToReservation(request);
        reservation.setUser(userEntity);
        reservation.setBook(book);

        Reservation savedreservation=reservationRepository.save(reservation);

        return reservationMapper.entityToReservationResp(savedreservation);
    }

    @Override
    public ReservationResp update(ReservationRequest request, Long aLong) {
        return null;
    }

    @Override
    public ReservationResp getById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<ReservationResp> getAll(int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Reservation> reservationPage=reservationRepository.findAll(pageRequest);
        return reservationPage.map(reservationMapper::entityToReservationResp);
    }
}
