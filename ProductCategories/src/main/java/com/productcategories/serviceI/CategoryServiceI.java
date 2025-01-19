package com.productcategories.serviceI;

import java.util.List;

import com.productcategories.exception.CategoryException;
import com.productcategories.model.Category;
import com.productcategories.request.CategoryRequest;

public interface CategoryServiceI {

	public List<Category> getAllCategory();

	public void createCategory(CategoryRequest category);

	public Category getCategoryId(Integer id);

	public void updateCategory(Integer id, Category category) throws CategoryException;

	public void deleteCategory(Integer id);
}
