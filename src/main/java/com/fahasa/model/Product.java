package com.fahasa.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product implements Serializable {
	@Id
	Integer id;
	String name;
	@OneToMany(mappedBy = "product")
	List<Book> books;
	@OneToMany(mappedBy = "product")
	List<SchoolTool> schooltools;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderdetails;
	@OneToMany(mappedBy = "product")
	List<Review> reviews;
}
