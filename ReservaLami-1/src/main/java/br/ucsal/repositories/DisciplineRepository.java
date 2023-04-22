package br.ucsal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.models.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}