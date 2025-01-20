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
import com.productcategories.exception.ProductException;
import com.productcategories.model.Product;
import com.productcategories.request.CategoryRequest;
import com.productcategories.request.ProductRequest;


@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductServiceI psi;
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct()
	{
		return psi.getAllProduct();
	}
	
	@PostMapping("/createProduct")
	public String createProduct(@RequestBody ProductRequest product)
	{
		try
		{
			psi.createProduct(product);
			return "Create Category Successfully";
		}
		catch (ProductException p) {
			
		    return p.getMessage();
		}	
	}
	@GetMapping("/getProductId/{id}")
	public Product getProductId(@PathVariable("id") Integer id)
	{
		return psi.getProductId(id);
	}
	
	@PutMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable("id") Integer id,@RequestBody Product product)
	{
		try
		{
			psi.updateProduct(id,product);
			return "Update Successfully!....";
		}
		catch(Exception p) {
			return p.getMessage();
		}
		
	}
	
	@DeleteMapping("/deleteProcut/{id}")
	public String deleteProductId(@PathVariable("id") Integer id)
	{
		psi.deleteProductId(id);
		return "Delete Product Id Successfully.";
	}
	
}
