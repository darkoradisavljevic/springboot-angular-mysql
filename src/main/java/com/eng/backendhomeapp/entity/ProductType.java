package com.eng.backendhomeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "product_type")
public class ProductType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_type_id")
	private Integer productTypeId;
	
	@Column(name = "product_type_name", length = 50, nullable = false)
	@Size(max = 50, message = "Product type name must be up to 50 characters long")
	@NotNull
	private String productTypeName;
	
//	@OneToMany(mappedBy = "productType", orphanRemoval = true,cascade = CascadeType.ALL)
//	private List<Product> products;
}
