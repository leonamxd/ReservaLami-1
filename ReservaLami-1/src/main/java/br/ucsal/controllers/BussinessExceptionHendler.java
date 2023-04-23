package br.ucsal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.ucsal.dto.BussinessExceptionDTO;
import br.ucsal.exceptions.BussinessException;

@RestControllerAdvice
public class BussinessExceptionHendler {

	public ResponseEntity<BussinessExceptionDTO> handleCustomException(BussinessException erro) {
		BussinessExceptionDTO dto = new BussinessExceptionDTO(erro.getMessage());
		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}
}
