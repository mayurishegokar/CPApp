package com.productcategories.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.exception.CategoryException;
import com.productcategories.model.Category;
import com.productcategories.repository.CategoryRepository;
import com.productcategories.request.CategoryRequest;
import com.productcategories.serviceI.CategoryServiceI;

@Service
public class CategoryServiceImpl implements CategoryServiceI {

	@Autowired
	CategoryRepository cr;
	
	
	@Override
	public List<Category> getAllCategory() {
		return cr.findAll() ;
	}


	@Override
	public void createCategory(CategoryRequest category) {
		Category c=new Category();
		c.setCategoryId(category.getId());
		c.setCategoryName(category.getName());
		c.setCategoryDescription(category.getDescription());
		cr.save(c);
		
	}


	@Override
	public Category getCategoryId(Integer id) {
		
		Optional<Category> op=cr.findById(id);
		if(op.isPresent())
		{
			Category c=op.get();
			return c;
		}
		return null;	
	}


	@Override
	public void updateCategory(Integer id,Category category) throws CategoryException {
		Category c=cr.findById(id).orElseThrow(()->new CategoryException("Category Id does not match"));
		
		c.setCategoryName(category.getCategoryName());
		c.setCategoryDescription(category.getCategoryDescription());
		cr.save(c);
		
		
	}


	@Override
	public void deleteCategory(Integer id) {
		cr.deleteById(id);
		
	}

}
