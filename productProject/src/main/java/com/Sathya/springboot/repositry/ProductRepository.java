package com.Sathya.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sathya.springboot.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{

}
