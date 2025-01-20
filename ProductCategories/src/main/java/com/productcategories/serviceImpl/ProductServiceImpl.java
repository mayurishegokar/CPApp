package com.productcategories.serviceImpl;

import java.awt.print.PrinterException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.exception.CategoryException;
import com.productcategories.exception.ProductException;
import com.productcategories.model.Category;
import com.productcategories.model.Product;
import com.productcategories.repository.CategoryRepository;
import com.productcategories.repository.ProductRepository;

import com.productcategories.serviceI.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductRepository pr;
	
	@Autowired
	CategoryRepository cr;
	
	@Override
	public List<Product> getAllProduct() {
		
		return pr.findAll();
	}

	@Override
	public void createProduct(Product product) throws ProductException {
		
		Optional<Category> op=cr.findById(product.getCategory().getCategoryId());
		
		if(!op.isPresent())
		{
	      throw new ProductException("Category Id does not match. ");
		}
		pr.save(product);
		
	}

	@Override
	public Product getProductId(Integer id)  {
		Optional<Product> op=pr.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		return null;
	}

	@Override
	public void updateProduct(Integer id, Product product) throws ProductException, CategoryException {
	     Product p=pr.findById(id).orElseThrow(()->new ProductException("Product Id does not match."));
	     
	     Optional<Category> op=cr.findById(product.getCategory().getCategoryId());
	     if(!op.isPresent())
	     {
	    	 throw new CategoryException("Category Id does not match");
	     }
	     p.setProductName(product.getProductName());
	     p.setProductDescription(product.getProductDescription());
	     p.setCategory(product.getCategory());
	     pr.save(p);
	}

	@Override
	public void deleteProductId(Integer id) throws ProductException {
		Optional<Product> op=pr.findById(id);
		
		if(op.isPresent())
		{
			Product p=op.get();
			pr.deleteById(id);
		}
		else
		{
			 throw new ProductException("Category Id does not match. ");
		}
		
		
	}
	

}
