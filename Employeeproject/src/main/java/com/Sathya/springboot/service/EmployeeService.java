package com.Sathya.springboot.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sathya.springboot.entity.EmployeeEntity;
import com.Sathya.springboot.model.Employee;
import com.Sathya.springboot.repositry.EmployeeRepositry;

@Service
public class EmployeeService 
{
  @Autowired
  EmployeeRepositry employeeRepositry;
  public List<EmployeeEntity>getAllEmployees(){
	 List<EmployeeEntity> employees=employeeRepositry.findAll();
	 return employees;
  }
	public void  saveEmployeeDetails(Employee employeeModel)
	{
		double hra;
		hra=employeeModel.getHraper()*employeeModel.getSalary();
		double da;
		da=employeeModel.getDaper()*employeeModel.getSalary();
		double finalsalary;
		finalsalary=hra+da;
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setDept(employeeModel.getDept());
		employeeEntity.setGender(employeeModel.getGender());
		employeeEntity.setLocation(employeeModel.getLocation());
		employeeEntity.setDa(da);
		employeeEntity.setHra(hra);
		employeeEntity.setFinalsalary(finalsalary);
		employeeEntity.setSalary(employeeModel.getSalary());
        employeeRepositry.save(employeeEntity);
	}
	public EmployeeEntity searchById(Long id) {
		
	
	Optional <EmployeeEntity> optionalData=employeeRepositry.findById(id);
	if(optionalData.isPresent())
	{
		EmployeeEntity employee=optionalData.get();
		return employee;
	}
	else
	{
		return null;
	}
	
}
	public void deleteById(Long id)
	{
		employeeRepositry.deleteById(id);
	}
	public Employee editById(Long id)
	{
		Optional <EmployeeEntity>  optionaldata=employeeRepositry.findById(id);
		Employee employees=new Employee();
		if(optionaldata.isPresent())
		{ 
		   EmployeeEntity eemployee=optionaldata.get();
			employees.setName(eemployee.getName());
			employees.setDept(eemployee.getDept());
			employees.setSalary(eemployee.getSalary());
			employees.setGender(eemployee.getGender());
			employees.setLocation(eemployee.getLocation());
			return   employees;
			
		}
		else
		{
			return null;
		}
	}
}

