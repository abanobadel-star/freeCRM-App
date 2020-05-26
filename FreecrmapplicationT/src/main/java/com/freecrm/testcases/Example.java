package com.freecrm.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Example {
	  @Test
	  public void print() throws IOException
	  {
		  
	  
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream("F:\\ITI software testing\\testing\\selenium work\\FreecrmapplicationT\\src\\main\\java\\com\\freecrm\\config\\cinfig.properties");
		prop.load(fis);
		 String url=prop.getProperty("URL");
		 System.out.println(url);
		 
	
	  }
	  
}

