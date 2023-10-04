package com.excel.excelgenerator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.excel.excelgenerator.repository.CategoryRepository;

@SpringBootTest
class ExcelGeneratorApplicationTests {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCategory() {
		System.out.println("Test started..");
		this.categoryRepository.findAll().forEach(cat -> System.out.println(cat.getTitle()));
	}

}
