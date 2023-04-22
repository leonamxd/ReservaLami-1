package br.ucsal.dto;

public class CustomExceptionDTO {

	private String mensage;
	
	public CustomExceptionDTO(String mensage) {
		this.mensage = mensage;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
}