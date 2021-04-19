package com.qa.myproject.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;
import com.qa.myproject.utils.Constants;

public class ShoppinCartTest extends BaseTest{
	
	
	
	@BeforeClass
	public void shoppingCartSetup()
	{
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@Test(priority=-1)
	public void verifyItemTextAfterAddToCartTest()
	{
		
		String productName="samsung";
		homePage.doSearch(productName);
		
		productInfoPage=homePage.selectProdctFromSearch("Samsung Galaxy Tab 10.1");
		
		productInfoPage.AddToCart();
		
		shoppingCartPage=productInfoPage.getToShoppingCart();
		
		Assert.assertTrue(shoppingCartPage.verifyAddedItemText());
	}
	
	@Test
	
	public void verifyProductModelTest()
	{
		String model="Samsung";
		String pModel=shoppingCartPage.verifyProductModel(model);
		
		Assert.assertEquals(pModel, Constants.SAMSUNG_MODEL_NUMBER);
	}
	
	@Test 
	public void verifyProdUnitPriceTest()
	{
		String model="Samsung";
		String pModel=shoppingCartPage.verifyProductUnitPrice(model);
		
		Assert.assertEquals(pModel, "$199.99");
	}
	
	@Test 
	public void verifyProdTotalPriceTest()
	{
		String model="Samsung";
		String pModel=shoppingCartPage.verifyProductTotalPrice(model);
		
		Assert.assertEquals(pModel, "$199.99");
	}
	
	@Test
	
	public void verifySubTotalTest()
	{
		String subTot=shoppingCartPage.verifySubTotal();
		
		Assert.assertEquals(subTot, "$14,399.99");
	}
	
	@Test
	
	public void verifyTotalTest()
	{
		String tot=shoppingCartPage.verifyTotal();
		
		Assert.assertEquals(tot, "$14,399.99");
	}
	
	@Test
	
	public void checkoutTest()
	{
	 shoppingCartPage.doCheckout();
		
	}
	
	public void continueShopping()
	{
		System.out.println("Continue Shopping");
	}

}
