package com.fahasa.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "Users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String phone;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String address;
	@JsonManagedReference(value = "authority-user")
	@OneToMany(mappedBy = "user")
	List<Authority> authorities;
	@JsonManagedReference(value = "order-user")
	@OneToMany(mappedBy = "user")
	List<Order> orders;
	@JsonManagedReference(value = "review-user")
	@OneToMany(mappedBy = "user")
	List<Review> reviews;
}
