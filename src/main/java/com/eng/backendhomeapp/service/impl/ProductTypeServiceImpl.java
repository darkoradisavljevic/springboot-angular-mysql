package com.eng.backendhomeapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.backendhomeapp.entity.ProductType;
import com.eng.backendhomeapp.repository.ProductTypeRepository;
import com.eng.backendhomeapp.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Override
	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	@Override
	public void createNew(ProductType productType) {
		productTypeRepository.save(productType);
		
	}

}
