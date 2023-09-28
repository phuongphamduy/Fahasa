package com.fahasa.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String author;
	private Double price;
	private Integer discount;
	private String description;
	private Integer stock;
	@ManyToOne
	@JoinColumn(name = "subcategoryid")
	SubCategory subcategory;
	@OneToMany(mappedBy = "book")
	List<OrderDetail> orderdetails;
	@OneToMany(mappedBy = "book")
	List<Review> reviews;
}
