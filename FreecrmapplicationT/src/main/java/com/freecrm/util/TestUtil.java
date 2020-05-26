package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	public  static Object[][] getdatafromExcel(String sheetname) throws IOException
	{
		File file=new File("F:\\ITI software testing\\testing\\selenium work\\data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetname);
		 String data= sheet.getRow(0).getCell(2).toString();
		 System.out.println(data);
		 int rows=sheet.getLastRowNum();
		 int cols=sheet.getRow(0).getLastCellNum();
		 Object data1[][]=new Object[rows][cols]; 
		 for(int i=0;i<rows;i++)
			 
		 {
			 for(int j=0;j<cols;j++)
			 {
				 data1[i][j]=sheet.getRow(i).getCell(j).toString();
			 }
		 } 
		 return data1 ;
	}
	

}
