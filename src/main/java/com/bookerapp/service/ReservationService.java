package com.bookerapp.service;

import com.bookerapp.model.Reservation;
import com.bookerapp.repository.ReservationRepository;

public class ReservationService {
	
	private ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	// READ (BY ID)
	public Reservation findById(int id) {
		return reservationRepository.findById(id).get();
	}

	// READ (ALL)
	public Iterable<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	// CREATE
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	// DELETE
	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	// UPDATE
	public Reservation updateReservation(int reservationId, Reservation reservation) {
		Reservation updatedReservation = reservationRepository.findById(reservationId).get();
		if (reservation.getDepartureDate() != null) {
			updatedReservation.setDepartureDate(reservation.getDepartureDate());
		}
		return reservationRepository.save(updatedReservation);
	}
	
	//Erika Anne Baravio
}
