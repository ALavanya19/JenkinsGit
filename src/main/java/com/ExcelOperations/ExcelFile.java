package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	static FileInputStream excelFile;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	private static void readExcelFile(String excelFilePath,String sheetName) throws IOException {
		
		excelFile=new FileInputStream(excelFilePath);
	    workbook=new XSSFWorkbook(excelFile);
		sheet=workbook.getSheet(sheetName);
	}
	
	public static String readExcelFileOperation(String excelFilePath,String sheetName,int rowNum,int cellNum) throws IOException {
		
		readExcelFile(excelFilePath,sheetName);
		XSSFRow row=sheet.getRow(rowNum);
		XSSFCell cell=row.getCell(cellNum);
		String cellData=cell.getStringCellValue();
	    return cellData;
	
	}
	
	public static void writeExcelFileOperation(String excelFilePath,String sheetName,int rowNum,int cellNum,String cellData,String excelFileSavePath) throws IOException {
		
		readExcelFile(excelFilePath,sheetName);
		XSSFRow row=sheet.getRow(rowNum);
		XSSFCell cell=row.getCell(cellNum);
		cell.setCellValue(cellData);
	    //return cellData;
		
		saveExcelFile(excelFileSavePath);
		
	}
	
	private static void saveExcelFile(String excelFileSavePath) throws IOException {
		
			FileOutputStream excelFileSave=new FileOutputStream(excelFileSavePath);
			workbook.write(excelFileSave);
		    excelFileSave.close();
			
	}
	

	public static Object[][] multipleTestDataReader(String excelFilePath,String sheetName) throws IOException{
	
		Object data[][];
		readExcelFile(excelFilePath,sheetName);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		data=new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		for(int row=1;row<=sheet.getLastRowNum();row++) {
			for(int cell=0;cell<sheet.getRow(0).getLastCellNum();cell++) {
				
				data[row][cell]=sheet.getRow(row).getCell(cell).toString();
			}
		}
		
		
		return data;
	}
	
	
}
