package com.qa.myproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.myproject.utils.ElementsUtil;

public class ShoppingCart {
	
    private WebDriver driver;
	
	private ElementsUtil util;
	
	private By itemText=By.xpath("//div[@id='content']/h1");
	
	//private By cartProductModel=By.xpath("(//a[contains(text(),'\"+modelName+\"')])[2]//parent::td//following-sibling::td[1]");
	
	private By subTotal=By.xpath("//strong[text()='Sub-Total:']//parent::td//following-sibling::td");
	
	private By total=By.xpath("//strong[text()='Total:']//parent::td//following-sibling::td");
	
	private By checkout=By.xpath("//a[text()='Checkout']");
	
	
	
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
		
		util=new ElementsUtil(driver);
	}
	
	public boolean verifyAddedItemText()
	{
		return util.getElement(itemText).isDisplayed();
		
	}
	
	public String verifyProductModel(String modelName)
	{
		return driver.findElement(By.xpath(" (//a[contains(text(),'"+modelName+"')])[2]//parent::td//following-sibling::td[1]")).getText();
		
		
		
	}
	
	public String verifyProductUnitPrice(String modelName)
	{
		
		return driver.findElement(By.xpath(" (//a[contains(text(),'"+modelName+"')])[2]//parent::td//following-sibling::td[3]")).getText();
	}
	
	
	public String verifyProductTotalPrice(String modelName)
	{
		
		return driver.findElement(By.xpath(" (//a[contains(text(),'"+modelName+"')])[2]//parent::td//following-sibling::td[4]")).getText();
	}
	
	
	public String verifySubTotal()
	{
		return util.getElement(subTotal).getText();
	}
	
	
	public String verifyTotal()
	{
		return util.getElement(total).getText();
	}
	
	public void doCheckout()
	{
                util.doClick(checkout);
	}
	

}
