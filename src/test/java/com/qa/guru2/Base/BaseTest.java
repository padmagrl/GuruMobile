package com.qa.guru2.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.guru2.Factory.DriverFactory;
import com.qa.guru2.Pages.CheckOutPage;
import com.qa.guru2.Pages.HomePage;
import com.qa.guru2.Pages.MobilePage;
import com.qa.guru2.Pages.ProdDetailsPage;

public class BaseTest {
	DriverFactory df;
	public WebDriver d;
	public Properties prop;
	public HomePage hp;
	public MobilePage mp;
	public ProdDetailsPage pp;
	public CheckOutPage cp;
	
	
	
	
	@BeforeClass
	public void setUp()
	{
		df=new DriverFactory();
		prop=df.init_prop();
		d=df.init_driver(prop);
		hp=new HomePage(d);
	}
	@AfterClass
	public void tearDown()
	{
		d.quit();
	}

}
