package br.ucsal.exceptions;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CustomException(String mensage) {
		super(mensage);
	}
	public CustomException(String mensage, Throwable couse) {
		super(mensage, couse);
	}
}