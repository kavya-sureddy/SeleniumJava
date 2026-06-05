package FileInputOutputReadWrite;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class xceldemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		

		
		String filePath = "Testing_Kavya.xlsx";
	
		try (XSSFWorkbook workbook = new XSSFWorkbook()){
		
		XSSFSheet sheet = workbook.createSheet("LoginTestData");
		XSSFSheet sheet1 = workbook.createSheet("FullStackTestingSyllabus");
		XSSFSheet sheet2 = workbook.createSheet("TestData");
		
		sheet.createRow(0).createCell(0).setCellValue("Username");
		sheet.getRow(0).createCell(1).setCellValue("Password");
		
		sheet1.createRow(0).createCell(0).setCellValue("Functional Testing");
		sheet1.createRow(1).createCell(0).setCellValue("API");
		sheet1.createRow(2).createCell(0).setCellValue("Selenium");
		
		sheet2.createRow(2).createCell(2).setCellValue("Test 2/2 Data Insertion");
		
		
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook1 =  new XSSFWorkbook(fis);
		
		XSSFSheet sheet3 = workbook1.getSheet("FullStackTestingSyllabus");
		
		String Value = sheet3.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Value in Excel Sheet - FullStackTestingSyllabus " + Value );
		
	}
		
	
	}

}
