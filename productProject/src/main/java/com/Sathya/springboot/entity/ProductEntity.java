package com.Sathya.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Product")



public class ProductEntity 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int Quantity;
	private double discountrate;
	private double taxRate;
	private double discountPrice;
	private double offerPrice;
	private double finalPrice;
	private double stockValue;
		
}
