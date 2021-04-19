package com.qa.myproject.utils;


import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.myproject.base.BasePage;

public class ElementsUtil {
	
	
	private WebDriver driver;
	
	private JavascriptUtil js;
	
	public ElementsUtil(WebDriver driver)
	{
		this.driver=driver;
		js=new JavascriptUtil(driver);
	}
	
	
	
	public void visibilityOfAllElements(List<WebElement> elements,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	
	public WebElement getElement(By locator)
	{
		WebElement element=driver.findElement(locator);
		
 	if(BasePage.highlight.equals("true"))
	{			js.flash(element);		}
	
		return element;
	
	
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	
	
	public WebElement waitForElementPresent(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		return getElement(locator);
	}
	
	
	public WebElement waitForElementToBeClickable(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		return getElement(locator);
		
		
		
		
	}
	
	
	public void clickWhenReady(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	 getElement(locator).click();
		
	}
	public WebElement visibilityOfElement(By locator,int timeout)
	{
		WebElement element=getElement(locator);
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return element;
	}
	public WebElement visibilityOfElementLocated(By locator,int timeout)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return getElement(locator);
	}
	
	public String waitForUrlTobe(String url,int timeout)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlContains(url));
		
		return driver.getCurrentUrl();
	}
	
	public boolean waitForAlertTobePresent(int  timeout)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.alertIsPresent());
		
		return true;
	}
	
	
	
	
	
	public void doClick(By locator)
	{
		try
		{
		getElement(locator).click();
	    }
		catch(Exception e)
		{
			System.out.println("Some exception occured while clicking");
		}
	}
	
	public void doSendKeys(By locator,String value)
	{
		try
		{
		getElement(locator).sendKeys(value);
	    }
		catch(Exception e)
		{
			System.out.println("Some exception occured while sending keys");
		}
	}
	
	
	
	public void doActionsSendKeys(By locator,String value)
	{
          WebElement element=getElement(locator);
		Actions actions=new Actions(driver);
		actions.sendKeys(element, value).perform();
		
	}
	
	public void doActionsClick(By locator)
	{
          WebElement element=getElement(locator);
		Actions actions=new Actions(driver);
		actions.click(element).perform();
		
	}
	
	
	
	public String waiForTitle(String title,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(title));
		
		return driver.getTitle();
	}
	
	public boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	
	
}
