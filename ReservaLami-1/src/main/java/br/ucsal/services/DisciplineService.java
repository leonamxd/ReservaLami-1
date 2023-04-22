package br.ucsal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.models.Discipline;
import br.ucsal.repositories.DisciplineRepository;

@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository disciplineRepository;

	public List<Discipline> findAll() {
		return disciplineRepository.findAll();
	}

	public void deleteById(Long id) {
		disciplineRepository.deleteById(id);
	}
}