package com.productcategories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcategories.model.Category;
import com.productcategories.request.CategoryRequest;
import com.productcategories.serviceI.CategoryServiceI;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryServiceI csi;
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory()
	{
		return csi.getAllCategory();
	}
	
	@PostMapping("/createCategory")
	public String createCategory(@RequestBody CategoryRequest category)
	{
		csi.createCategory(category);
		return "Create Category Successfully";
	}
	
	@GetMapping("/getCategoryId/{id}")
	public Category getCategoryId(@PathVariable("id") Integer id)
	{
		return csi.getCategoryId(id);
	}
	
	@PutMapping("/updateCategory/{id}")
	public String updateCategory(@PathVariable("id") Integer id, @RequestBody Category category)
	{
		try
		{
			csi.updateCategory(id,category);
			return "Category Update Successfully.";
		}
		catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategoryId(@PathVariable("id") Integer id)
	{
		csi.deleteCategory(id);
		return "Category Delete Successfully.";
	}
	

}
