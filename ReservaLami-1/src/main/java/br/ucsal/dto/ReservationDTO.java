package br.ucsal.dto;

import org.springframework.beans.factory.annotation.Autowired;

import br.ucsal.models.Discipline;
import br.ucsal.models.Laboratory;
import br.ucsal.models.Reservation;
import br.ucsal.models.Teacher;


public class ReservationDTO {

	@Autowired
	private ReservationRepository repository;
	
	private Laboratory laboratory;
	private Teacher teacher;
	private Discipline discipline;
	
	
	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public Reservation save(Reservation reserva) {
		return repository.save(reserva);
	}
}