package br.ucsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.models.Laboratory;
import br.ucsal.models.StatusLaboratory;
import br.ucsal.repositories.LaboratoryRepository;

@Service
public class LaboratoryService {

	@Autowired
	private LaboratoryRepository laboratoryRepository;
	

	public List<Laboratory> findAll() {
		return laboratoryRepository.findAll();
	}
	
	public void deleteById(Long id) {
		laboratoryRepository.deleteById(id);
	}

	public Boolean searchAvailability(Long id) {		
		Optional<Laboratory> laboratory = laboratoryRepository.findById(id);		
		return laboratory.get().getStatus().equals(StatusLaboratory.AVAILABLE);
	}

}