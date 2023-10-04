package com.excel.excelgenerator.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.excelgenerator.model.Category;
import com.excel.excelgenerator.service.CategoryService;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<List<Category>> addAllCat(@RequestBody ArrayList<Category> list) {
		
		List<Category> categories = this.categoryService.addCategories(list);
		return ResponseEntity.status(HttpStatus.CREATED).body(categories);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCat(){
		List<Category> allCategories = this.categoryService.getAllCategories();
		return ResponseEntity.ok(allCategories);
	}
	
	@RequestMapping("/excel")
	public ResponseEntity<Resource> download() throws IOException{
		String filename = "categories.xlsx";
		
		ByteArrayInputStream actualData = this.categoryService.getActualData();
		InputStreamResource file = new InputStreamResource(actualData);
		
		ResponseEntity<Resource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
		return body;
	}
	
}
