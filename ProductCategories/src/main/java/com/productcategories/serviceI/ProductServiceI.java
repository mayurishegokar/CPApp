package com.productcategories.serviceI;

import java.util.List;

import org.springframework.stereotype.Service;
import com.productcategories.model.Product;
import com.productcategories.request.ProductRequest;

@Service
public interface ProductServiceI {

	public List<Product> getAllProduct();

	public void createProduct(ProductRequest product);
	

}
