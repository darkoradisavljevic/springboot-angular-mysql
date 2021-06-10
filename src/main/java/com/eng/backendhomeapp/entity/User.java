package com.eng.backendhomeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private Integer idUser;
	
	@Column(length = 20, nullable = false)
	@Size(max = 20, message = "Name must be up to 20 characters long")
	@NotNull
	private String name;
	
	@Column(length = 20, nullable = false)
	@Size(max = 20, message = "Surname must be up to 20 characters long")
	@NotNull
	private String surname;

}
