package com.eng.backendhomeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.backendhomeapp.entity.ProductType;



public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
