package com.Sathya.springboot.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sathya.springboot.entity.ProductEntity;
import com.Sathya.springboot.model.ProductModel;
import com.Sathya.springboot.repositry.ProductRepository;

import jakarta.persistence.Entity;

@Service
public class ProductService
{ 
	@Autowired
	ProductRepository productRepository;
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	public ProductEntity searchById(Long id) 
	{
		Optional<ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
	}
	
	
	public List<ProductEntity> getAllproduct(){
		List<ProductEntity> products=productRepository.findAll();
		return products;
	}
	public void  saveProductDetails(ProductModel productModel)
	{
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountrate()/100;
		
		double offerprice;
		offerprice=productModel.getPrice()-productModel.getDiscountrate();
		
		double finalprice;
		finalprice=productModel.getTaxrate()+offerprice;
		
		double stockValue;
		stockValue=productModel.getQuantity()*offerprice+productModel.getTaxrate()/100;
		
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName()); 
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountrate(productModel.getDiscountrate());
		productEntity.setTaxRate(productModel.getTaxrate());
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setOfferPrice(offerprice);
		productEntity.setFinalPrice(finalprice);
		productEntity.setStockValue(stockValue);
		productRepository.save(productEntity);

		
	}
	public ProductModel editByID(Long id) 
	{
		Optional<ProductEntity> optionaldata =productRepository.findById(id);
		 ProductModel product= new  ProductModel();
		if(optionaldata.isPresent()) 
		{ 
		   ProductEntity eproduct=optionaldata.get();
		   product.setName(eproduct.getName());
		   product.setBrand(eproduct.getBrand());
		   product.setMadeIn(eproduct.getMadeIn());
		   product.setPrice(eproduct.getPrice());
		   product.setQuantity(eproduct.getQuantity());
		   product.setDiscountrate(eproduct.getDiscountrate());
		   return product;
		}
		else
		{
			return null;
		}
		   
	}

	
		
	

	public void  updata(ProductModel productModel, Long id) {
		Optional< ProductEntity> optional=productRepository.findById(id);
		if(optional.isPresent())
		{
			ProductEntity entity=optional.get();
			entity.setName(productModel.getName());
		    entity.setBrand(productModel.getBrand());
			entity.setDiscountrate(productModel.getDiscountrate());
			entity.setMadeIn(productModel.getMadeIn());
			entity.setPrice(productModel.getPrice());
			entity.setQuantity(productModel.getQuantity());
			double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountrate()/100;
			
			double offerprice;
			offerprice=productModel.getPrice()-productModel.getDiscountrate();
			double finalprice;
			finalprice=productModel.getTaxrate()+offerprice;
			
			double stockValue;
			stockValue=productModel.getQuantity()*offerprice+productModel.getTaxrate()/100;
			productRepository.save(entity);
			
		
	    }

  }
}
   
