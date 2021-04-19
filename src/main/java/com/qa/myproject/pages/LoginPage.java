package com.qa.myproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.myproject.base.BasePage;
import com.qa.myproject.utils.Constants;
import com.qa.myproject.utils.ElementsUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	
	private ElementsUtil util;
	//1.By Locators Object Repository
	
	private By emailId=By.id("input-email");
	
	private By password=By.id("input-password");
	
	private By loginBtn=By.xpath("//input[@type='submit'  and @value='Login']");
	private By registerAccount=By.xpath("//strong[contains(text(),'Register Account')]");
	private By itemCart=By.xpath("//span[@id='cart-total']");
	private By forgotPassword=By.linkText("Forgotten Password");
	
	private By totalLinksCount=By.xpath("//footer//div[@class='row']//a");
	private By newCustomerAddButton=By.xpath("//a[contains(text(),'Continue')]");
	
	private By registerLink=By.linkText("Register");
	//2 Constructor of the page class
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementsUtil(driver);
	}
	
	//3 Page Actions Behaviour of the page
	
	public String getLoginPageTitle()
	{
		return util.waiForTitle(Constants.LOGIN_PAGE_TITLE, 20);
	}
	
	public boolean isRegisterAccountTextExist()
	{
		return util.doIsDisplayed(registerAccount);
	}
	
	public WebElement isItemTextInCart()
	{
		return util.getElement(itemCart);
	}
	public AccountsPage doLogin(String uname,String upass)
	{
		util.doSendKeys(emailId, uname);
		util.doSendKeys(password, upass);
		
		util.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	public boolean isForgotPasswordDisplayed()
	{
		return util.doIsDisplayed(forgotPassword);
	}
	
	public List<WebElement> getTotalLinksFooter()
	{
		return util.getElements(totalLinksCount);
		
	}
	
	public boolean isNewCustomerAddButtonEnabled()
	{
		return driver.findElement(newCustomerAddButton).isEnabled();
	}
	
	public Register doRegistration()
	{
		util.doClick(registerLink);
		
		return new Register(driver);
	}

}
