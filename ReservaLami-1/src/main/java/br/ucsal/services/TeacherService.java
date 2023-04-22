package br.ucsal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.models.Teacher;
import br.ucsal.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired 
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
	
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
	}
}
