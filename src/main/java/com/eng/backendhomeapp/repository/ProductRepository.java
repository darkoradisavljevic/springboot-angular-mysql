package com.eng.backendhomeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.backendhomeapp.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
