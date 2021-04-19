package com.qa.myproject.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.myproject.base.BaseTest;
import com.qa.myproject.utils.Constants;
import com.qa.myproject.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	
	
	@BeforeClass
	
	public void registerPageSetup()
	{
		register=loginPage.doRegistration();
	}
	
	@Test(dataProvider="getRegisterData")
	public void userRegistrationTest(String firstname,String lastname,String email,String telephone,String password,String subscribe)
	{
		register.accountRegistration(firstname,lastname,email,telephone,password,subscribe);
	}
	
	
	@DataProvider
	public Object[][] getRegisterData()
	{
		Object data[][]=ExcelUtil.getTestData(Constants.SHEET_NAME);
		return data;
	}

}
