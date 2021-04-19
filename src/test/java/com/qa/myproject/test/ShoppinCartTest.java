package com.qa.myproject.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

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
		
		String productName="macbook";
		homePage.doSearch(productName);
		
		productInfoPage=homePage.selectProdctFromSearch("MacBook Pro");
		
		productInfoPage.AddToCart();
		
		shoppingCartPage=productInfoPage.getToShoppingCart();
		
		Assert.assertTrue(shoppingCartPage.verifyAddedItemText());
	}
	
	@Test
	
	public void verifyProductModelTest()
	{
		String model="MacBook Pro";
		String pModel=shoppingCartPage.verifyProductModel(model);
		
		
		
		Assert.assertEquals(pModel, Constants.MacBOOK_MODEL_NUMBER);
	}
	
	@Test 
	public void verifyProdUnitPriceTest()
	{
		String model="MacBook Pro";
		String pModel=shoppingCartPage.verifyProductUnitPrice(model);
		
//		DecimalFormat formatter = new DecimalFormat("#,###.00");
//        String imac_Unit_Price=formatter.format(Constants.IMAC_UNIT_PRICE);
		
		String unit_price=shoppingCartPage.unitPriceFormatter("MacBook");		
		Assert.assertEquals(pModel, unit_price);
	}
	
	@Test 
	public void verifyProdTotalPriceTest()
	{
		String model="MacBook Pro";
		String pModel=shoppingCartPage.verifyProductTotalPrice(model);
		
		//String untiPrice=shoppingCartPage.verifyProductUnitPrice(model).split("$")[0].trim();
		
		//double uPrice=Double.parseDouble(untiPrice);
		
		String quantity=shoppingCartPage.getProductqunatity(model);
		
		System.out.println(quantity);
		
		double q=Double.parseDouble(quantity);
		
		
		
		double tot=q*Constants.MACBBOK_UNIT_PRICE;
		
		System.out.println(tot);
		
		
		

		DecimalFormat formatter = new DecimalFormat("#,###.00");
        String tot2=formatter.format(tot);
        
        String totalPrice="$"+tot2;
        
        System.out.println(totalPrice);
		
		 
        
		
		
		
		
		
		Assert.assertEquals(pModel,totalPrice );
	}
	
	@Test(enabled=false)
	
	public void verifySubTotalTest()
	{
		String subTot=shoppingCartPage.verifySubTotal();
		
		Assert.assertEquals(subTot, "$14,399.99");
	}
	
	@Test(enabled=false)
	
	public void verifyTotalTest()
	{
		String tot=shoppingCartPage.verifyTotal();
		
		Assert.assertEquals(tot, "$14,399.99");
	}
	
	@Test(enabled=false)
	
	public void checkoutTest()
	{
	 shoppingCartPage.doCheckout();
		
	}
	
	

}
