package br.ucsal.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.dto.ReservationDTO;
import br.ucsal.models.Reservation;
import br.ucsal.services.ReservationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reserva")
public class ReservationController {

	
	@Autowired
	private ReservationService reservationService;
	
	
	@PostMapping
	public ResponseEntity<Reservation> insert(@RequestBody @Valid ReservationDTO _reservation){
		Reservation reservation = new Reservation();
		BeanUtils.copyProperties(_reservation, reservation);
		reservation.setStartTime(LocalDateTime.now(ZoneId.of("UTC")));
		reservation.setEndTime(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(_reservation.save(reservation));
	}
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<Reservation> cancel(@PathVariable Long id) {
		Reservation updatedReservation = reservationService.cancelReservation(id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedReservation);
	}
}