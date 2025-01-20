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
import com.productcategories.request.ProductRequest;
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
	public void createProduct(ProductRequest product) throws ProductException {
		Product pd=new Product();
		
		pd.setProductId(product.getId());
		pd.setProductName(product.getName());
		pd.setProductDescription(product.getDescription());
		
		Optional<Category> op=cr.findById(product.getCategory().getCategoryId());
		
		if(op.isPresent())
		{
	       pd.setCategory(op.get());
		}else {
			throw new ProductException("Category Id not Present "+product.getCategory().getCategoryId());
		}
		pr.save(pd);
		
	}

}
