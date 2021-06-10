package com.eng.backendhomeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name = "product_name", length = 50, nullable = false)
	@Size(max = 50, message = "Product name must be up to 50 characters long")
	@NotNull
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "product_type_id")
	@NotNull
	private ProductType productType;
	
	
	
	
}
