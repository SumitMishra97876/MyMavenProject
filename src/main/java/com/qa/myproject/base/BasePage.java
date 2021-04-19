package com.qa.myproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.myproject.utils.Options_Manager;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Sumit
 *
 */
public class BasePage {
	
	public WebDriver driver;
	 public Properties prop;
	 
	 public static String highlight;
	 
	 public Options_Manager options;
	 
	 public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	/**
	 * This method is used to initialize the driver on the basis of given driver
	 * @param browser
	 * @return 
	 */
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value is : " +browser);
		
		highlight = prop.getProperty("highlight");
		
		options=new Options_Manager(prop);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options.getChromeOptions()));
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(options.getFirefoxOptions()));
		}
		else
		{
			System.out.println("Please pass the correct browser");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
	}
	
	
	
	/**
	 * getDriver using ThreadLocal
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns properties prop reference 
	 */
	
	public Properties init_prop()
	{
		prop=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("./src/main/java/com/qa/myproject/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot()
	{
		File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		
		File destination=new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	

}
