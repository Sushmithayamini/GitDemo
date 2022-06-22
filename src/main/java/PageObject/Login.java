package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public WebDriver driver;
	By email = By.cssSelector("input[type='email']");
	By pwd = By.cssSelector("input[type='password']");
	By btn = By.cssSelector("input[type='submit']");
	
	
	public Login(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(pwd);
	}
	
	public WebElement getloginBtn() {
		return driver.findElement(btn);
	}
	


}
