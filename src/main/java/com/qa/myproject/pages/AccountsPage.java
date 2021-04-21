package com.qa.myproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.myproject.base.BasePage;
import com.qa.myproject.utils.Constants;
import com.qa.myproject.utils.ElementsUtil;

public class AccountsPage extends BasePage {
	
	
	private WebDriver driver;
	
	private ElementsUtil util;
	private By header=By.xpath("//div[@id='logo']//a");
	
	private By accountHeaders=By.xpath("//div[@id='content']//h2");
	
	private By searchTextField=By.xpath("//div[@id='search']//input[@name='search']");
	
	private By searchIcon=By.xpath("//i[@class='fa fa-search']");
	private By UserAccount=By.xpath("//div[@id='content']//h2[1]");
	
	private By headeNavBaritems=By.xpath("//ul[@class='nav navbar-nav']/li/a");
	
	private By searchItemsResult=By.cssSelector(".product-layout .product-thumb");
	
	private By resultItems=By.xpath("//div[@class='product-thumb']//h4/a");
	private By cart=By.xpath("//div[@id='cart']/button");
	
	private By viewCart=By.xpath("(//p[@class='text-right']/a/strong/i)[1]");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		
		util=new ElementsUtil(driver);
	}
	
	public String getHomePageTitle()
	{
		return util.waiForTitle(Constants.HOME_PAGE_TITLE,10);
	}
	
	public String getHeaderValue()
	{
		if(util.doIsDisplayed(header))
		{
			return util.doGetText(header);
		}
		return null;
	}
	
	public boolean isSearchIconExist()
	{
		if(util.getElements(searchIcon).size()>0)
		{
			return true;
		}
		return false;
	}
	
	public String isUserAccountTextVisible()
	{
		if(util.doIsDisplayed(UserAccount))
		{
			return util.doGetText(UserAccount);
		}
		return null;
	}
	
	public int getAccountSectionsCount()
	{
		return util.getElements(accountHeaders).size();
	}
	
	public List<String>  getAccountSectionsList()
	{
		List<String> accountList=new ArrayList<String>();
	    List<WebElement> accountSectionList= util.getElements(accountHeaders);
	    for(WebElement ele:accountSectionList)
	    {
	    	accountList.add(ele.getText());
	    }
	    return accountList;
	}
	
	public List<WebElement> getHeaderNavBarItems()
	{
		return util.getElements(headeNavBaritems);
	}
	
	public boolean doSearch(String productName)
	{
		util.getElement(searchTextField).clear();
		util.doSendKeys(searchTextField, productName);
		
	
		
		util.doClick(searchIcon);
		
		
		
		if(util.getElements(searchItemsResult).size()>0)
		{
			return true;
		}
		return false;
	}
	
	
	public ProductInfoPage selectProdctFromSearch(String productName)
	{
		List<WebElement> resultItemList=util.getElements(resultItems);
		
		System.out.println("Total number of Items displayed :" +resultItemList.size());
		
		for(WebElement e: resultItemList)
		{
			if(e.getText().equals(productName))
			{
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	public ShoppingCart goToCart()
	{
		util.doClick(cart);
		
		util.doClick(viewCart);
		
		return new ShoppingCart(driver);
	}
	
	
	

}
