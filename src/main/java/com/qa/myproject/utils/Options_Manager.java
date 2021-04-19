package com.qa.myproject.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Options_Manager {
	
	
	private Properties prop;
	
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	public Options_Manager(Properties prop)
	{
		this.prop=prop;
	}
	
	
	public ChromeOptions getChromeOptions()
	{
		co=new ChromeOptions();
		if(prop.getProperty("incognito").trim().equals("true"))
		{
			co.addArguments("--incognito");
		}
		if(prop.getProperty("headless").trim().equals("true"))
		{
			co.addArguments("--headless");
		}
		return co;
	}
	
	

	public FirefoxOptions getFirefoxOptions()
	{
		fo=new FirefoxOptions();
		if(prop.getProperty("incognito").trim().equals("true"))
		{
			co.addArguments("--incognito");
		}
		if(prop.getProperty("headless").trim().equals("true"))
		{
			co.addArguments("--headless");
		}
		return fo;
	}
	
	
	

}
