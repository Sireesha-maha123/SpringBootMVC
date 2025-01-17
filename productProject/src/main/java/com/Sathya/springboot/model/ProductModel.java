package com.Sathya.springboot.model;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    @NotBlank(message =  "product name cannot be blank")
	private String name;
    @NotBlank(message = "brand  cannot be blank")
	private String brand;
    @NotBlank(message = "madeIn cannot be blank")
	private String madeIn;
    @Positive(message = "price must be greater than zero")
	private double price;
    @Min(value = 1,message = "Quantity must be atleast 1")
	private int Quantity;
    @DecimalMax(value = "100.0",message = "discountrate cannot exceed 100")
	private double discountrate;
	private double taxrate;
}
