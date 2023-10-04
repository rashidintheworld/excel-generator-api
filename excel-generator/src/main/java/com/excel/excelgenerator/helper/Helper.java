package com.excel.excelgenerator.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.excelgenerator.model.Category;

public class Helper {

	public static String[] HEADERS = { "id", "title", "description", "coverImage" };

	public static String SHEET_NAME = "category_data";

	public static ByteArrayInputStream dataToExcel(List<Category> list) throws IOException {
		
		// create workbook here
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			// create sheet
			Sheet sheet = workbook.createSheet(SHEET_NAME);

			// create row: header row
			Row row = sheet.createRow(0);

			for (int i = 0; i < HEADERS.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}

			// create row: value rows
			int rowIndex = 1;
			for (Category c : list) {

				Row dataRow = sheet.createRow(rowIndex);
				rowIndex += 1;

				dataRow.createCell(0).setCellValue(c.getCategoryId());
				dataRow.createCell(1).setCellValue(c.getTitle());
				dataRow.createCell(2).setCellValue(c.getDescription());
				dataRow.createCell(3).setCellValue(c.getCoverImage());
				
			}

			workbook.write(out);

			return new ByteArrayInputStream(out.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			workbook.close();
			out.close();	
		}
	}
}
