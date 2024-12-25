package com.Sathya.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sathya.springboot.entity.EmployeeEntity;
@Repository
public interface EmployeeRepositry extends JpaRepository<EmployeeEntity, Long>
{

}
