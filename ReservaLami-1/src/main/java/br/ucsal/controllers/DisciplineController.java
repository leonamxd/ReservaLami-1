package br.ucsal.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.dto.DisciplineDTO;
import br.ucsal.models.Discipline;
import br.ucsal.services.DisciplineService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {

	@Autowired
	private DisciplineService disciplineService;
	
	@RequestMapping("/newDiscipline")
	public String form() {
		return "discipline";
	}
	
	@GetMapping
	public ResponseEntity<List<Discipline>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(disciplineService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Discipline> insert(@RequestBody @Valid DisciplineDTO _discipline){
		Discipline discipline = new Discipline();
		BeanUtils.copyProperties(_discipline, discipline);
		return ResponseEntity.status(HttpStatus.CREATED).body(_discipline.save(discipline));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Discipline> update(@RequestBody @Valid DisciplineDTO _discipline, @PathVariable Long id) {
		Discipline discipline = new Discipline();
		BeanUtils.copyProperties(_discipline, discipline);
		return ResponseEntity.status(HttpStatus.OK).body(_discipline.save(discipline));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		disciplineService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}