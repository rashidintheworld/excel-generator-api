package com.excel.excelgenerator.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.excel.excelgenerator.model.Category;

public interface CategoryService {
	
	List<Category> addCategories(ArrayList<Category> list);
	
	List<Category> getAllCategories();
	
	ByteArrayInputStream getActualData() throws IOException;

}
