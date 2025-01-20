package com.productcategories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
