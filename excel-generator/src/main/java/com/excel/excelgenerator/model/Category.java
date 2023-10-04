package com.excel.excelgenerator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cat_excel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
	
	@Id
	@Column(name = "id")
	private String categoryId;
	
	@Column(name = "category_title", length = 40, nullable = false)
	private String title;
	
	@Column(name = "category_desc", length = 500)
	private String description;
	
	private String coverImage;

}
