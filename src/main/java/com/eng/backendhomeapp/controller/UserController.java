package com.eng.backendhomeapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.backendhomeapp.entity.User;
import com.eng.backendhomeapp.service.UserService;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	

	@GetMapping("/users")
    public List<User> showAll() {
        List<User> userList =  userService.findAll().stream().collect(Collectors.toList());
        return userList;
    }
	
	
	@GetMapping("/user/{idUser}")
    public User  showOne( @PathVariable("idUser") Integer idUser) {
		System.out.println(idUser + "user id");
		Optional<User> user = userService.findByIdUser(idUser);
		
        return user.get();
    }
	
	@PostMapping("/user")
	public void createNew(@RequestBody User user) {
		userService.createNew(user);
	}
	
	@PutMapping("/user/{idUser}")
	public void editUser(@RequestBody User user) {
    userService.editUser(user);	
	}
	
	@DeleteMapping("/user/{idUser}")
	public void deleteUser(@PathVariable("idUser") Integer idUser) {
    userService.deleteUser(idUser);	
	}
}
