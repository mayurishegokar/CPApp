package com.productcategories.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategories.exception.CategoryException;
import com.productcategories.model.Category;
import com.productcategories.repository.CategoryRepository;

import com.productcategories.serviceI.CategoryServiceI;

@Service
public class CategoryServiceImpl implements CategoryServiceI {

	@Autowired
	CategoryRepository cr;

	@Override
	public List<Category> getAllCategory() {
		return cr.findAll();
	}

	@Override
	public void createCategory(Category category) {
		cr.save(category);

	}

	@Override
	public Category getCategoryId(Integer id) {

		Optional<Category> op = cr.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;

	}

	@Override
	public void updateCategory(Integer id, Category category) throws CategoryException {
		Category c = cr.findById(id).orElseThrow(() -> new CategoryException("Category Id does not match"));

		c.setCategoryName(category.getCategoryName());
		c.setCategoryDescription(category.getCategoryDescription());

		cr.save(c);

	}

	@Override
	public void deleteCategory(Integer id) throws CategoryException {
		Optional<Category> op = cr.findById(id);
		if (op.isPresent()) {
			cr.deleteById(id);
		} else {
			throw new CategoryException("Category Id does not match");
		}

	}

}
