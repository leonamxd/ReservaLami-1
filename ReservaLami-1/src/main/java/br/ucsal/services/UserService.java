package br.ucsal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.models.User;
import br.ucsal.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private TeacherRepository teacherRepository;

	public boolean authenticate(String _userLogin, String _password) {
		User user = userRepository.findByLogin(_userLogin);
		if (!user.equals(_userLogin)) {
			return false;
		}
		return user.getPassword().equals(_password);
	}
}