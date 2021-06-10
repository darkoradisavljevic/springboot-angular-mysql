package com.eng.backendhomeapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.backendhomeapp.entity.ProductType;
import com.eng.backendhomeapp.service.ProductTypeService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE )
public class ProductTypeController {

	@Autowired
	ProductTypeService productTypeService;
	
	@GetMapping("/productTypes")
    public List<ProductType> showAll() {
        List<ProductType> productTypes =  productTypeService.findAll().stream().collect(Collectors.toList());
        return productTypes;
    }
	
	@PostMapping("/productType")
	public void createNew(@RequestBody ProductType productType) {
		System.out.println(productType);
		productTypeService.createNew(productType);
	}
}
