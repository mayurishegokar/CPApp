package com.productcategories.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.model.Category;
import com.productcategories.model.Product;
import com.productcategories.repository.ProductRepository;
import com.productcategories.request.ProductRequest;
import com.productcategories.serviceI.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductRepository pr;
	
	@Override
	public List<Product> getAllProduct() {
		
		return pr.findAll();
	}

	@Override
	public void createProduct(ProductRequest product) {
		Product pd=new Product();
		
		pd.setProductId(product.getId());
		pd.setProductName(product.getName());
		pd.setProductDescription(product.getDescription());
		Category category=new Category();
		category.setCategoryId(product.getId());
		pd.setCategory(category);
		
		pr.save(pd);
		
	}

}
