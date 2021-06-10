package com.eng.backendhomeapp.service;

import java.util.List;
import java.util.Optional;

import com.eng.backendhomeapp.entity.User;

public interface UserService {
	
	List<User> findAll();

	Optional<User> findByIdUser(Integer idUser);
	
	void createNew(User user);

	void editUser(User user);

	void deleteUser(Integer idUser);


}
