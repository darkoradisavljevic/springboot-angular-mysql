package com.eng.backendhomeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.backendhomeapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
