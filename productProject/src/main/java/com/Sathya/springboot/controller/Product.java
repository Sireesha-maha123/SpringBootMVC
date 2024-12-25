package com.Sathya.springboot.controller;

import java.util.HashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sathya.springboot.entity.ProductEntity;
import com.Sathya.springboot.model.ProductModel;
import com.Sathya.springboot.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class Product {
	@Autowired
	ProductService productService;
	
	@GetMapping("/getallproducts")
	public String getAllproducts(Model model)
	{
		List<ProductEntity> product=productService.getAllproduct();
		model.addAttribute("products",product);
		return "product-list";
	}
	
	@GetMapping("/productform")
	public String greet()
	{
		return "product";
	}
//  @PostMapping("/product")
// public String saveProduct(ProductModel productModel)
// {
//	productService.saveProductDetails(productModel);
//	return "success";
// }

  
@GetMapping("/searchproduct")
public String getsearchFrom()
{
	return "search-product";
}
@PostMapping("/searchbyid")
public String searchById(@RequestParam Long id,Model model)
{
	ProductEntity product=productService.searchById(id);
	model.addAttribute("product",product);
	return "search-product";
}
//delete opertions
@GetMapping("/delete/{id}")
public String deleteProductById(@PathVariable("id")Long id)
{
	productService.deleteProductById(id);
	return "redirect:/getallproducts";
}
@GetMapping("/edit/{id}")
public String  editByID(@PathVariable Long id,Model model)
{
	ProductModel product=productService.editByID(id);
	model.addAttribute("product",product);
	return "edit";
}
@PostMapping("/editproductsave/{id}")
public String updata(@PathVariable("id") Long id,ProductModel productModel) 
{
  productService.updata(productModel ,id);
  return  "redirect:/getallproducts";
}




@GetMapping("/productforms")
public String getprodcutform(Model model)
{
	ProductModel productModel=new ProductModel();
	productModel.setMadeIn("INDIA");
	productModel.setQuantity(2);
	productModel.setDiscountrate(10.5);
	model.addAttribute("productModel", productModel);
	return "add-prodcut";
}
@PostMapping("/saveProducts")
public String saveProducts(@Valid ProductModel productModel,BindingResult bindingresult,Model model) {
	HashMap<String , String > validationErrors=new HashMap<String ,String>();
	if(bindingresult.hasErrors())
	{
		for(FieldError fieldError:bindingresult.getFieldErrors())
		{
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		model.addAttribute("validationErrors",validationErrors);
		return "add-prodcut";
	}
	productService.saveProductDetails(productModel);
	return "redirect:/getallproducts";
}

}


