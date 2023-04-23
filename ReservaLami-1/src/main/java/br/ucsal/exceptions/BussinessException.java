package br.ucsal.exceptions;

public class BussinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BussinessException(String mensage) {
		super(mensage);
	}
	public BussinessException(String mensage, Throwable couse) {
		super(mensage, couse);
	}
}