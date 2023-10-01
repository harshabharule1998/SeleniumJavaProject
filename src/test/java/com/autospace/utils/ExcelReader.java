package com.autospace.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	HashMap<String, String> credentials;
	
	public static void main(String[] args) throws IOException {
		
		ExcelReader reader = new ExcelReader();
		HashMap<String, String> data = reader.readUserCredentialsFromExcel();
		System.out.println(data.get("id"));
		System.out.println(data.get("pass"));
		
	}
	
	public HashMap<String, String> readUserCredentialsFromExcel() throws IOException {
		
		FileInputStream file = new FileInputStream(new File("G:\\QaAutoSpace\\UserData.xlsx"));
		
		//Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        
        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        
        rowIterator.next();
        
        Row row2 = rowIterator.next();
        
        Iterator<Cell> cellIterator = row2.cellIterator();
        
        Cell cell = cellIterator.next();
        
        String userName = cell.getStringCellValue();
        
        cell = cellIterator.next();
        
        String password = cell.getStringCellValue();
        
        
        //System.out.println("UserName = " + userName + " Password = " + password);
        
        
        credentials = new HashMap<String, String>();
        
        credentials.put("id", userName);
        credentials.put("pass", password);
        
        /*while (rowIterator.hasNext()) {
        	
        	Row row = rowIterator.next();
        	
        	Iterator<Cell> cellIterator = row.cellIterator();
        	
        	while (cellIterator.hasNext()) {
        		
                Cell cell = cellIterator.next();
                
                System.out.println(cell.getStringCellValue());
                
        	}
        	
        }*/
        
        
        return credentials;
	}

}
