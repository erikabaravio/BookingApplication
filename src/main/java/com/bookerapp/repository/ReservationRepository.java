package com.bookerapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookerapp.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}
