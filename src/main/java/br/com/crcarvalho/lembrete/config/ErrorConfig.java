package br.com.crcarvalho.lembrete.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.crcarvalho.lembrete.controller.exception.LembreteNaoEncontradoException;

@ControllerAdvice
public class ErrorConfig {
	
	@ExceptionHandler(LembreteNaoEncontradoException.class)
	public ResponseEntity<String> notFoundException(LembreteNaoEncontradoException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
}
