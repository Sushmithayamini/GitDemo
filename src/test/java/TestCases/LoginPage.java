package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.Login;
import Resources.Base;

public class LoginPage extends Base{
	public WebDriver driver;
	
	public static Logger logs = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void browsrInitialization() throws IOException {
		driver = intializDriver();
		driver.get(prop.getProperty("Url"));
	}
	@Test(dataProvider="getData")
	public void homePage(String unr, String pwdr) throws IOException {
		driver = intializDriver();
		driver.get(prop.getProperty("Url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		logs.debug("Button is clicked successfully");
		Login l = new Login(driver);
		l.getEmail().sendKeys(unr);
		l.getPassword().sendKeys(pwdr);
		logs.info("text enter in to field");
		l.getloginBtn().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="resticted@gmail.com";
		data[0][1]="123456";
		data[1][0]="unretricted@gmail.com  ";
		data[1][1]="6789065 ";
		
		return data;
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
