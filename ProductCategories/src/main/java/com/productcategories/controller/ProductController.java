package com.productcategories.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcategories.serviceI.ProductServiceI;
import com.productcategories.exception.CategoryException;
import com.productcategories.exception.ProductException;
import com.productcategories.model.Product;


@RestController
@RequestMapping("/api/product")
public class ProductController  {

	@Autowired
	ProductServiceI psi;
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct()
	{
		return psi.getAllProduct();
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@RequestBody Product product) throws ProductException
	{
		
			psi.createProduct(product);
			return "Create Category Successfully";
			
	}
	@GetMapping("/getProductId/{id}")
	public Product getProductId(@PathVariable("id") Integer id,@RequestBody Product product) 
	{
		return psi.getProductId(id,product);
	}
	
	@PutMapping("/updateProductId/{id}")
	public String updateProduct(@PathVariable("id") Integer id,@RequestBody Product product) throws ProductException, CategoryException
	{
			psi.updateProduct(id,product);
			return "Update Successfully!....";
		
	}
	
	@DeleteMapping("/deleteProductId/{id}")
	public String deleteProductId(@PathVariable("id") Integer id) throws ProductException
	{
		psi.deleteProductId(id);
		return "Delete Product Successfully.";
	}
	
}
