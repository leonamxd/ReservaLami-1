package br.ucsal.dto;

public class BussinessExceptionDTO {

	private String mensage;
	
	public BussinessExceptionDTO(String mensage) {
		this.mensage = mensage;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
}