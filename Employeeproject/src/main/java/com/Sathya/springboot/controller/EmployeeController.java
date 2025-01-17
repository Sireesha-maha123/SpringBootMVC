package com.Sathya.springboot.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sathya.springboot.entity.EmployeeEntity;
import com.Sathya.springboot.model.Employee;

import com.Sathya.springboot.service.EmployeeService;


@Controller
public class EmployeeController 
{ 
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/getallemp")
	 public String getAllemployee(Model model)
	  {
		  List<EmployeeEntity> employees=employeeService.getAllEmployees();
		  model.addAttribute("employees",employees);
		  return "employee-list";
		  
	  }
	@GetMapping("/employee")
	public String greet()
	{
		return "employee";
	}
  @PostMapping("/employee")
  public String saveEmployee(Employee employeeModel)
  {
	  employeeService.saveEmployeeDetails(employeeModel);
	  return "suceessEmp";
  }
  @GetMapping("/search")
  public String getSerchForm() {
	  return "search-emp";
	  
  }
  @PostMapping("/searchbyid")
  public String searchById(@RequestParam Long id,Model model)
  {
	  EmployeeEntity employee=employeeService.searchById(id);
	  model.addAttribute("employee",employee);
	  return "search-emp";
  }
  @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable("id") Long id) {
	  employeeService.deleteById(id);
	  return "redirect:/getallemp";
  }
  @GetMapping("/edit/{id}")
  public String editById(@PathVariable Long id,Model model ) 
  {
	  Employee employee=employeeService.editById(id);
		model.addAttribute("employee",employee);
		return "edit-emp";
  }
  
}

