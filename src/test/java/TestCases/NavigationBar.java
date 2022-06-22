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

public class NavigationBar extends Base{
	
	public WebDriver driver;
	
	public static Logger logs = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void browsrInitialization() throws IOException {
		driver = intializDriver();
		driver.get(prop.getProperty("Url"));
	}
	@Test
	public void LandingPageText() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		logs.info("nav bar is displayed");

}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}