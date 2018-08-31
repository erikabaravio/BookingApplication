package com.bookerapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookerapp.model.Reservation;
import com.bookerapp.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	// READ (ALL)
	@GetMapping
	public Iterable<Reservation> getAllReservation() {
		return reservationService.findAll();
	}

	// CREATE
	@PostMapping
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		return reservationService.saveReservation(reservation);
	}

	// DELETE
	@DeleteMapping("/{reservationId}")
	public void deleteReservation(@PathVariable("reservationId") int reservationId) {
		reservationService.deleteReservation(reservationService.findById(reservationId));
	}

	// READ (BY ID)
	@GetMapping("/{reservationId}")
	public Reservation findReservation(@PathVariable("reservationId") int reservationId) {
		return reservationService.findById(reservationId);
	}

	// UPDATE
	@PutMapping("/{reservationId}")
	public Reservation updateReservation(@PathVariable("reservationId") int reservationId, @RequestBody Reservation reservation) {
		reservation.setReservationId(reservationId);
		return reservationService.updateReservation(reservationId, reservation);
	}

}
