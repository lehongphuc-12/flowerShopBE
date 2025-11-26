package com.phucle.flowerShopBE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucle.flowerShopBE.model.Category;
import com.phucle.flowerShopBE.service.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/topics")
	public ResponseEntity<List<Category>> getTopics() {
		
		List<Category> cateList = categoryService.getAllCategory();
		return ResponseEntity.ok(cateList);
	}
	
}
