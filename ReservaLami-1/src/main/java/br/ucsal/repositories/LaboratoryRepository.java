package br.ucsal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.models.Laboratory;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long>{

}