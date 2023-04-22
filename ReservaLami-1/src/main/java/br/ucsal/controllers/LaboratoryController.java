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

import br.ucsal.dto.LaboratoryDTO;
import br.ucsal.models.Laboratory;
import br.ucsal.services.LaboratoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/laboratorio")
public class LaboratoryController {

	@Autowired
	private LaboratoryService laboratoryService;
	
	@GetMapping
	public ResponseEntity<List<Laboratory>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(laboratoryService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Laboratory> insert(@RequestBody @Valid LaboratoryDTO _laboratory){
		Laboratory laboratorio = new Laboratory();
		BeanUtils.copyProperties(_laboratory, laboratorio);
		return ResponseEntity.status(HttpStatus.CREATED).body(_laboratory.save(laboratorio));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Laboratory> update(@RequestBody @Valid LaboratoryDTO _laboratory, @PathVariable Long id) {
		Laboratory laboratorio = new Laboratory();
		BeanUtils.copyProperties(_laboratory, laboratorio);
		return ResponseEntity.status(HttpStatus.OK).body(_laboratory.save(laboratorio));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		laboratoryService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}