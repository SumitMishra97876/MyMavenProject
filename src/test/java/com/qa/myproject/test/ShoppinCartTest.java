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
	
	
	@Test
	public void verifyItemTextAfterAddToCartTest()
	{
		
		String productName="sony";
		homePage.doSearch(productName);
		
		productInfoPage=homePage.selectProdctFromSearch("Sony VAIO");
		
		productInfoPage.AddToCart();
		
		shoppingCartPage=productInfoPage.getToShoppingCart();
		
		Assert.assertTrue(shoppingCartPage.verifyAddedItemText());
	}
	
	
	@Test(priority=-1)
	
	public void arriveToCartTest()
	{
		shoppingCartPage=homePage.goToCart();
	}
	
	@Test
	
	public void verifyProductModelTest()
	{
		String model="Sony VAIO";
		String pModel=shoppingCartPage.verifyProductModel(model);
		
		
		
		Assert.assertEquals(pModel, Constants.SONY_MODEL_NUMBER);
	}
	
	@Test 
	public void verifyProdUnitPriceTest()
	{
		String model="Sony VAIO";
		String pModel=shoppingCartPage.verifyProductUnitPrice(model);
		
//		DecimalFormat formatter = new DecimalFormat("#,###.00");
//        String imac_Unit_Price=formatter.format(Constants.IMAC_UNIT_PRICE);
		
		String unit_price=shoppingCartPage.unitPriceFormatter("Sony VAIO");		
		Assert.assertEquals(pModel, unit_price);
	}
	
	@Test 
	public void verifyProdTotalPriceTest()
	{
		String model="Sony VAIO";
		String pModel=shoppingCartPage.verifyProductTotalPrice(model);
		
		//String untiPrice=shoppingCartPage.verifyProductUnitPrice(model).split("$")[0].trim();
		
		//double uPrice=Double.parseDouble(untiPrice);
		
		String quantity=shoppingCartPage.getProductqunatity(model);
		
		System.out.println(quantity);
		
		double q=Double.parseDouble(quantity);
		
		
		
		double tot=q*Constants.SONY_UNIT_PRICE;
		
		System.out.println(tot);
		
		
		

		DecimalFormat formatter = new DecimalFormat("#,###.00");
        String tot2=formatter.format(tot);
        
          String totalPrice="$"+tot2;
        
        System.out.println(totalPrice);
		
		 Assert.assertEquals(pModel,totalPrice );
	}
	
	@Test
	public String verifyTotalCartPriceTest()
	{
		String qImac=shoppingCartPage.getProductqunatity("iMac");
		double quantityImac=Double.parseDouble(qImac);
		
		double totImac=quantityImac*Constants.IMAC_UNIT_PRICE;
		
		String qMac=shoppingCartPage.getProductqunatity("MacBook Pro");
		double quantityMac=Double.parseDouble(qMac);
		
		double totMac=quantityMac*Constants.MACBBOK_UNIT_PRICE;
		
		
		String qSam=shoppingCartPage.getProductqunatity("Samsung");
		double quantitySam=Double.parseDouble(qSam);
		
		double totSam=quantitySam*Constants.SAMSUNG_UNIT_PRICE;
		
		
		
		String qSony=shoppingCartPage.getProductqunatity("Sony VAIO");
		double quantitySony=Double.parseDouble(qSony);
		
		double totSony=quantitySony*Constants.SONY_UNIT_PRICE;
		
		double totalCartItemPrice=totImac+totMac+totSam+totSony;
		
		
		DecimalFormat formatter = new DecimalFormat("#,###.00");
        String totalCartItemsPrice=formatter.format(totalCartItemPrice);
        
          String totalCheckoutAmount="$"+totalCartItemsPrice;
          
          System.out.println(totalCheckoutAmount);
        
		  return totalCheckoutAmount;
		
		
		
		
	}
	
	@Test
	
	public void verifySubTotalTest()
	{
		String subTot=shoppingCartPage.verifySubTotal();
		
		String subTotal =verifyTotalCartPriceTest();

		Assert.assertEquals(subTot, subTotal);
	}
	
	@Test
	
	public void verifyTotalTest()
	{
		String tot=shoppingCartPage.verifyTotal();
		
		String total=verifyTotalCartPriceTest();
		
		Assert.assertEquals(tot, total);
	}
	
	@Test(priority=2)
	
	public void checkoutTest()
	{
	 shoppingCartPage.doCheckout();
		
	}
	
	

}
