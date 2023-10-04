package com.excel.excelgenerator.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.excelgenerator.helper.Helper;
import com.excel.excelgenerator.model.Category;
import com.excel.excelgenerator.repository.CategoryRepository;
import com.excel.excelgenerator.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> addCategories(ArrayList<Category> list) {

		List<Category> catList = list.stream().map((cat) -> this.setId(cat)).collect(Collectors.toList());

		return this.categoryRepository.saveAll(catList);
	}

	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}

	private Category setId(Category category) {
		String id = UUID.randomUUID().toString();
		return new Category(id, category.getTitle(), category.getDescription(), category.getCoverImage());
	}

	@Override
	public ByteArrayInputStream getActualData() throws IOException {
		ByteArrayInputStream dataToExcel = Helper.dataToExcel(getAllCategories());
		return dataToExcel;
	}

}
