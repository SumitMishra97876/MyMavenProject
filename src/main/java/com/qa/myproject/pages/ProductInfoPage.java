package com.qa.myproject.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.myproject.base.BasePage;
import com.qa.myproject.utils.ElementsUtil;

public class ProductInfoPage extends BasePage {
	
	private WebDriver driver;
	
	private ElementsUtil util;
	
	
	private By productNameHeader=By.cssSelector("#content h1");
	
	private By productMetaData=By.xpath("(//div[@id='content']//ul)[3]/li");
	
	private By productPrice=By.xpath("(//div[@id='content']//ul)[4]/li");
	
	private By quantity=By.id("input-quantity");
	private By addToCartButton=By.id("button-cart");
	
	private By productImages=By.cssSelector(".thumbnails li img");
	
	private By addToCartMessage=By.cssSelector(".alert-success");
	private By shoppingCart=By.cssSelector(".alert-success a:nth-child(2)");

	
    
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementsUtil(driver);
	}
	
	public Map<String, String> getProductInfo()
	{
		Map<String,String> productInfoMap=new HashMap<String,String>();
		
		productInfoMap.put("name", util.getElement(productNameHeader).getText().trim());
	     
		
		     List<WebElement> productMetaDataList= util.getElements(productMetaData);
		     
		     for(WebElement e: productMetaDataList)
		     {
		    	 productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		     }
		     
		     List<WebElement> productPriceList=util.getElements(productPrice);
		     
		     productInfoMap.put("Price",productPriceList.get(0).getText().trim());
		     productInfoMap.put("ExclusiveTax",productPriceList.get(1).getText().split(":")[1].trim());
		     
		     
		     return productInfoMap;
		     
	}
	
	public void selectQuantity(String qty)
	{
		util.doSendKeys(quantity, qty);
	}
	
	public boolean AddToCart()
	{
		util.doClick(addToCartButton);
		return util.waitForElementPresent(addToCartMessage,10).isDisplayed();
		
		
		
		
	}
	
	public int getProductImages()
	{
		int imagesCount= util.getElements(productImages).size();
		return imagesCount;
	}
	
	public String getProductInfoPageTitle(String productName)
	{
		return util.waiForTitle(productName,10);
		
		
	}
	
	public ShoppingCart getToShoppingCart()
	{
		util.waitForElementPresent(shoppingCart, 10).click();
		
		return new ShoppingCart(driver);
	}
}
