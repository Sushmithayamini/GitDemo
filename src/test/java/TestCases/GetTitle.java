package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import Resources.Base;

public class GetTitle extends Base{
	public WebDriver driver;
	public static Logger logs= LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	@BeforeTest
	public void browsrInitialization() throws IOException {
		driver = intializDriver();
		logs.info("Browser invoked");
		driver.get(prop.getProperty("Url"));
		logs.info("Navigated to urls");
	}
	@Test
	public void LandingPageText() throws IOException {
		
		 lp= new LandingPage(driver);
		Assert.assertEquals(lp.getword().getText(), "FEATURED COURSES");
	}
	
	@Test
	public void BannerTitle() {
		lp= new LandingPage(driver);
		Assert.assertEquals(lp.getBannerTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		System.out.println("Github testing");
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

}
