package com.productcategories.serviceI;

import java.util.List;

import com.productcategories.exception.CategoryException;
import com.productcategories.exception.ProductException;
import com.productcategories.model.Product;

public interface ProductServiceI {

	public List<Product> getAllProduct();

	public void createProduct(Product product) throws ProductException;

	public Product getProductId(Integer id);

	public void updateProduct(Integer id, Product product) throws ProductException, CategoryException;

	public void deleteProductId(Integer id) throws ProductException;

}
