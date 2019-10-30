package br.com.crcarvalho.lembrete.controller.exception;

public class LembreteNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LembreteNaoEncontradoException(String message) {
		super(message);
	}
	
}
