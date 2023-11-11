package com.fahasa.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schooltools")
public class SchoolTool implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String title;
	String brand;
	Double price;
	Integer discount;
	String description;
	String images;
	@JsonBackReference(value = "schooltool-product")
	@ManyToOne
	@JoinColumn(name = "productid")
	Product product;
	@JsonBackReference(value = "schooltool-category")
	@ManyToOne
	@JoinColumn(name = "categoryid")
	Category category;
}
