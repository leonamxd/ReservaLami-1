package br.ucsal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}