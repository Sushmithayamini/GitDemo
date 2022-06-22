package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static  WebDriver driver;
	public static Properties prop;

	public static WebDriver intializDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		//String brname = System.getProperty("browser");
		String brname = prop.getProperty("browser");
		if(brname.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(brname.contains("headless")) {
				options.addArguments("headless");
			}
			//System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(brname.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.firefox.driver", "D:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(brname.equals("IE")) {
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.firefox.driver", "D:\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public static String getScreenshotFile(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testMethodName+".jpg";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	

}