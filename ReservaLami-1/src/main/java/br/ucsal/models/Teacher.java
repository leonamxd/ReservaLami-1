package br.ucsal.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_teacher")
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	
	private String nameTeacher;
	
	private String emailTeacher;
	
	@OneToMany
	@JoinColumn(name = "discipline_id")
	private List<Discipline> disciplines;
		
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
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
	public List<Discipline> getDisciplines() {
		return disciplines;
	}
	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
}

