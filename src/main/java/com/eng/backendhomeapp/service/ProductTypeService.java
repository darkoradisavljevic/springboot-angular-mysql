package com.eng.backendhomeapp.service;

import java.util.List;

import com.eng.backendhomeapp.entity.ProductType;

public interface ProductTypeService {
	
	List<ProductType> findAll();

	void createNew(ProductType productType);

}
