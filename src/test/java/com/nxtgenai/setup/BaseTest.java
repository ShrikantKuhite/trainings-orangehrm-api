package com.nxtgenai.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	public static Properties config = new Properties();
	private FileInputStream fis;
	public static String baseURI;

	@BeforeSuite
	public void setUp() {

		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
			System.out.println("Properties file loaded successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baseURI=config.getProperty("baseURI");	
	}
	
	@AfterSuite
	public void tearDown() {
		System.out.println("Execution Completed");
	}

}
