package br.ucsal.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.ucsal.models.Discipline;
import br.ucsal.models.Teacher;
import jakarta.validation.constraints.NotBlank;

public class TeacherDTO {

	@Autowired
	private TeacherRepository repository;

	@NotBlank
	private String nameTeacher;
	@NotBlank
	private String emailTeacher;
	
	private List<Discipline> disciplines;

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public String getEmailTeacher() {
		return emailTeacher;
	}

	public void setEmailTeacher(String emailTeacher) {
		this.emailTeacher = emailTeacher;
	}

	public Teacher save(Teacher professor) {
		return repository.save(professor);
	}
}