package com.productcategories.serviceI;

import java.util.List;


import com.productcategories.exception.CategoryException;
import com.productcategories.model.Category;


public interface CategoryServiceI {

	public List<Category> getAllCategory();

	public void createCategory(Category category);

	public Category getCategoryId(Integer id);

	public void updateCategory(Integer id, Category category) throws CategoryException;

	public void deleteCategory(Integer id) throws CategoryException;
}
