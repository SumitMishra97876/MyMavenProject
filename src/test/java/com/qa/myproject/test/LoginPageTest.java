package com.qa.myproject.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;

import com.qa.myproject.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		
		
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is : " +title);
		
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
   
	
	@Test(priority=2)
	public void verifyRegisterAccountTest()
	{
		
		Assert.assertTrue(loginPage.isRegisterAccountTextExist());
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void verifyItemTextInCart()
	{
		
		String itemtext=loginPage.isItemTextInCart().getText();
		
		Assert.assertEquals(itemtext, Constants.ITEM_TEXT_IN_CART);
	}
	@Test()
	public void isForgotPassLinkEnabled()
	{
		
		Assert.assertTrue(loginPage.isForgotPasswordDisplayed());
	}
	
	@Test
	
	public void verifyTotalLinksInFooter()
	{
		
		List<WebElement>totLinks=loginPage.getTotalLinksFooter();
		int actualLinksCount=totLinks.size();
		System.out.println(actualLinksCount);
		Assert.assertEquals(actualLinksCount, Constants.TOTAL_FOOTER_LINKS);
	}
	
	@Test
	public void verifyNewCustAddButtonEnabled()
	{
		
		Assert.assertTrue(loginPage.isNewCustomerAddButtonEnabled());
	}
}
