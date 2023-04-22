package br.ucsal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserLogin(String _userLogin);

}