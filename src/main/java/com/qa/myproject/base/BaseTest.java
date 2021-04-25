package com.qa.myproject.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.qa.myproject.pages.AccountsPage;
import com.qa.myproject.pages.LoginPage;
import com.qa.myproject.pages.ProductInfoPage;
import com.qa.myproject.pages.Register;
import com.qa.myproject.pages.ShoppingCart;

public class BaseTest  {
	
	public BasePage basePage;
	public LoginPage loginPage;
	
	public AccountsPage homePage;
	
	public ProductInfoPage productInfoPage;
	
	public Register register;
	
	public ShoppingCart shoppingCartPage;
	
	public Properties prop;
	public WebDriver driver;
	@BeforeTest
	
	public void setUp()
	{
		basePage=new BasePage();
        prop=basePage.init_prop();
		String browserName=	prop.getProperty("browser");
		
		
	//driver=	basePage.init_driver(browserName);
	driver=basePage.init_driver(browserName);
	loginPage=new LoginPage(driver);
	
	driver.get(prop.getProperty("url"));
	
		
	}
	
	
	@AfterTest
	
	public void tearDown()
	{
		//driver.quit();
	}

}
