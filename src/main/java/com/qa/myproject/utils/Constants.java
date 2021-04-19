package com.qa.myproject.utils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Constants {
   public static final String LOGIN_PAGE_TITLE="Account Login";
   public static final String ITEM_TEXT_IN_CART="0 item(s) - $0.00";
   public static final int TOTAL_FOOTER_LINKS=15;
   
   public static final String HOME_PAGE_TITLE="My Account";
   public static final String HOME_PAGE_HEADER="Your Store";
   
   public static final String USER_ACCOUNT_TEXT="My Account";
   public static final int HEADER_NAV_BAR_ITEMS_SIZE=8;
   
   public static final int ACCOUNTS_SECTION=4;
   
   public static final String SHEET_NAME="registration";
   
   public static final String ACCOUNT_CREATION_SUCCESS_MSG="Your Account Has Been Created!";
   
   
   public static final String IMAC_MODEL_NUMBER="Product 14";
   
   public static final String MacBOOK_MODEL_NUMBER="Product 18";
   
   public static final String SAMSUNG_MODEL_NUMBER="SAM1";
   
   public static  double SAMSUNG_UNIT_PRICE=199.99;
   
   public static  double IMAC_UNIT_PRICE=100.00;
   
   public static  double MACBBOK_UNIT_PRICE=2000.00;
   
   
   
   static double n=2000.00;
	static NumberFormat nm=NumberFormat.getInstance(new Locale("en", "US"));
	
	public static final String MACBOOK_UPRICE =nm.format(n);
	
	
   
   
   
   
   public static List<String> getAccountSectionsList()
   {
	   List<String> acctList=new ArrayList<String>();
	   acctList.add("My Account");
	   acctList.add("My Orders");
	   acctList.add("My Affiliate Account");
	   acctList.add("Newsletter");
	   
	   return acctList;
   }
}
