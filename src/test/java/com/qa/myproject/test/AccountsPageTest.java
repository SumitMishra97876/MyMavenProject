package com.qa.myproject.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;
import com.qa.myproject.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	
	public void homeSetup()
	{
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority=2)
	public void homePageTitleTest()
	{
		String homeTitle=homePage.getHomePageTitle();
		System.out.println("Home Page Title is : " +homeTitle);
		
		Assert.assertEquals(homeTitle, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void verifyHomeHeaderTest()
	{
		String headerVal=homePage.getHeaderValue();
		System.out.println("Home Page Header is :" +headerVal);
		Assert.assertEquals(headerVal, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifySearchIconTest()
	{
	   Assert.assertTrue(homePage.isSearchIconExist());
	}
	
	@Test(priority=4)
	
	public void isAccountUserTextVisibleTest()
	{
		String utext=homePage.isUserAccountTextVisible();
		
		System.out.println("User Account Text is : " +utext);
		
		Assert.assertEquals(utext,Constants.USER_ACCOUNT_TEXT);
	}
	
	@Test(priority=5)
	
	public void verifyNavBarItemsList()
	{
		List<WebElement> items=homePage.getHeaderNavBarItems();
		int size=items.size();
		
		for(WebElement ele:items)
		{
			System.out.println(ele.getText());
		}
		
		Assert.assertEquals(size, Constants.HEADER_NAV_BAR_ITEMS_SIZE);
	}
	
	@Test(priority=6)
	public void verifyAccountSectionsCountTest()
	{
		Assert.assertTrue(homePage.getAccountSectionsCount()==Constants.ACCOUNTS_SECTION);
	}
	
	@Test(priority=7)
	
	public void verifyAccountSectionsListTest()
	{
		homePage.getAccountSectionsList();
		
		Assert.assertEquals(homePage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}
	
	@Test(priority=8)
	
	public void searchTest()
	{
		Assert.assertTrue(homePage.doSearch("imac"));	
	}
}
