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

import br.ucsal.dto.TeacherDTO;
import br.ucsal.models.Teacher;
import br.ucsal.services.TeacherService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(teacherService.findAll());
	}

	@PostMapping
	public ResponseEntity<Teacher> insert(@RequestBody @Valid TeacherDTO _teacher) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(_teacher, teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(_teacher.save(teacher));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> update(@RequestBody @Valid TeacherDTO _teacher, @PathVariable Long id) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(_teacher, teacher);
		return ResponseEntity.status(HttpStatus.OK).body(_teacher.save(teacher));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		teacherService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}