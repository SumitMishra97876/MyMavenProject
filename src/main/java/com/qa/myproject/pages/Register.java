package com.qa.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.myproject.base.BasePage;
import com.qa.myproject.utils.Constants;
import com.qa.myproject.utils.ElementsUtil;

public class Register extends BasePage {
	
	
	ElementsUtil util;
	
	
	private By firstname=By.id("input-firstname");
	
	private By lastname=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	
	private By subscribeYes=By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']");
	private By subscribeNo=By.xpath("//input[@type='radio' and @value='0']");
	
	private By privacyPolicy=By.xpath("//input[@name='agree']");
	
	private By continueButton=By.xpath("//input[@type='submit' and @value='Continue']");
	
	private By accountCreatedSuccessMsg=By.xpath("//div[@id='content']/h1");
	
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	
	public Register(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementsUtil(driver);
	}
	
	
	public boolean accountRegistration(String firstname,String lastname,String email,String telephone,String password,String subscribe)
	{
		util.doSendKeys(this.firstname, firstname);
		util.doSendKeys(this.lastname, lastname);
		util.doSendKeys(this.email, email);
		util.doSendKeys(this.telephone, telephone);
		util.doSendKeys(this.password, password);
		util.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equals("yes"))
		{
			util.doClick(subscribeYes);
		}
		else if(subscribe.equals("no"))
		{
			util.doClick(subscribeNo);
		}
		
		
		util.doClick(privacyPolicy);
		util.doClick(continueButton);
		
		
		String successText=util.getElement(accountCreatedSuccessMsg).getText();
		
		if(successText.contains(Constants.ACCOUNT_CREATION_SUCCESS_MSG))
		{
			util.doClick(logoutLink);
			util.doClick(registerLink);
			return true;
		}
		else
		{
			return false;
		}
	}

}
