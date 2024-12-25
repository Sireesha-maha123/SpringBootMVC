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
@Table(name="Employee")
public class EmployeeEntity 
{ 
	   @Id
	   @GeneratedValue(strategy =GenerationType.AUTO)
	   private long id;
	   private String name;
	   private String dept;
	   private double salary;
	   private char gender;
	   private String location;
	   private double hra;
	   private double da;
	   private double finalsalary;
	   
	   
}
