package br.ucsal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.ucsal.dto.CustomExceptionDTO;
import br.ucsal.exceptions.CustomException;

@RestControllerAdvice
public class CustomExceptionHendler {

	public ResponseEntity<CustomExceptionDTO> handleCustomException(CustomException erro) {
		CustomExceptionDTO dto = new CustomExceptionDTO(erro.getMessage());
		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}
}
