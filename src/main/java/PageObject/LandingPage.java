package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By login = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	
	private By text = By.xpath("(//div[@class='text-center'])[1]");
	
	private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	private By title = By.cssSelector("div[class*='video-banner'] h3");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getword() {
		return driver.findElement(text);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getBannerTitle() {
		return driver.findElement(title);
		
	}

}
