package FreeCRMApplicationTest.FreecrmapplicationT;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import com.freecrmbase.Base;
//import FreeCRMApplicationTest.FreeCRMApplicationTest.Base;
import FreeCRMApplicationTest.FreecrmapplicationT.Base;

public class TestUtil extends Base {

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void takepicture(String name) throws IOException
	{
		 File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File ("F:\\ITI software testing\\testing\\selenium work\\selenium_work\\snapshot\\"+name+".png"));
				
	}
	
	public static Object[][] getdatafromexel(String sheetname) throws Exception
	{
		
		File file=new File("F:\\ITI software testing\\testing\\selenium work\\data.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet= workbook.getSheet(sheetname);
		int row=sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		Object data[][]=new Object[row][columns];
		for(int i=0;i<row;i++)
		{
			for(int k=0;k<columns;k++)
			{
				data[i][k]=sheet.getRow(i).getCell(k).toString();
				
			}
			
		}
		return data;
		
		
	}

}
