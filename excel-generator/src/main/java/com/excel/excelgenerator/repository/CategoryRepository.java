package com.excel.excelgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.excelgenerator.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
