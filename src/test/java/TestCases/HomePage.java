package TestCases;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger logs = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void browsrInitialization() throws IOException {
		driver = intializDriver();
		driver.get(prop.getProperty("Url"));
	}
	@Test
	public void Homepagetc() throws IOException {
		
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
