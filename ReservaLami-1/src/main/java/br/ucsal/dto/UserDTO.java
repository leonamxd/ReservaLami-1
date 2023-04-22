package br.ucsal.dto;

import org.springframework.beans.factory.annotation.Autowired;

import br.ucsal.models.User;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	
	@Autowired
	private UserRepository repository;

	@NotBlank
	private String login;
	@NotBlank
	private String password;
	@NotBlank
	private Boolean teacher;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getTeacher() {
		return teacher;
	}
	public void setTeacher(Boolean teacher) {
		this.teacher = teacher;
	}
	
	public Object save(User usuario) {
		return repository.save(usuario);
	}
}