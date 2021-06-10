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
@Entity(name = "product_subtype")
public class ProductSubtype {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_subtype_id")
	private Integer productSubtypeId;
	
	@Column(name = "product_subtype_name", length = 50, nullable = false)
	@Size(max = 50, message = "Product subtype name must be up to 50 characters long")
	@NotNull
	private String productSubtypeName;
	
	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

}
