package com.productcategories.serviceI;

import java.util.List;


import org.springframework.stereotype.Service;

import com.productcategories.exception.CategoryException;
import com.productcategories.exception.ProductException;
import com.productcategories.model.Product;


@Service
public interface ProductServiceI {

	public List<Product> getAllProduct();

	public void createProduct(Product product) throws ProductException;

	public Product getProductId(Integer id);

	public void updateProduct(Integer id, Product product) throws ProductException, CategoryException;

	public void deleteProductId(Integer id) throws ProductException;
	

}
