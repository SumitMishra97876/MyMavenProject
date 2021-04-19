package com.qa.myproject.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	
	@BeforeClass
	public void productsInfoTestSetup()
	{
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	
	public void productInfoPageTitleTest()
	{
		String productName="imac";
		homePage.doSearch(productName);
		
		productInfoPage=homePage.selectProdctFromSearch("iMac");

		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"),"iMac");
	}
	
	
	@Test
	
	public void verifyProducInfoTest_MacBook()
	{
		String productName="Macbook";
		Assert.assertTrue(homePage.doSearch(productName));
		
		productInfoPage=homePage.selectProdctFromSearch("MacBook Pro");
		
		Assert.assertTrue(productInfoPage.getProductImages()==4);
		
     	Map<String,String> productInfoMap=productInfoPage.getProductInfo();
		System.out.println(productInfoMap);
		
		Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
		
	}
	
	@Test
	
	public void verifyProducInfoTest_iMac()
	{
		String productName="imac";
		Assert.assertTrue(homePage.doSearch(productName));
		
		productInfoPage=homePage.selectProdctFromSearch("iMac");
		
		Assert.assertTrue(productInfoPage.getProductImages()==3);
		
		Map<String,String> productInfoMap=productInfoPage.getProductInfo();
		System.out.println(productInfoMap);
		
		Assert.assertEquals(productInfoMap.get("name"), "iMac");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Price"), "$100.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		//Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
		
		
		
	}	@Test(priority=4)
	public void addToCartItemTest()
	{
	
	boolean addToCartMessage=productInfoPage.AddToCart();
		
		Assert.assertTrue(addToCartMessage);
	}

}
