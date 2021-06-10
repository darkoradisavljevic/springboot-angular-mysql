package com.eng.backendhomeapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.backendhomeapp.entity.User;
import com.eng.backendhomeapp.repository.UserRepository;
import com.eng.backendhomeapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

	@Override
	public Optional<User> findByIdUser(Integer idUser) {
		return userRepository.findById(idUser);
	}

	@Override
	public void createNew(User user) {
		userRepository.save(user);
	}

	@Override
	public void editUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public void deleteUser(Integer idUser) {
		userRepository.deleteById(idUser);
		
	}

}
