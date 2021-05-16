package com.qa.guru2.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.guru2.Factory.DriverFactory;
import com.qa.guru2.Pages.CheckOutPage;
import com.qa.guru2.Pages.CompareProductsPage;
import com.qa.guru2.Pages.CreateAccPage;
import com.qa.guru2.Pages.DashBoardPage;
import com.qa.guru2.Pages.HomePage;
import com.qa.guru2.Pages.LoginPage;
import com.qa.guru2.Pages.MobilePage;
import com.qa.guru2.Pages.ProdDetailsPage;
import com.qa.guru2.Pages.ShareWishListPage;
import com.qa.guru2.Pages.TVPage;
import com.qa.guru2.Pages.TVProdDetailsPage;
import com.qa.guru2.Pages.WishListPage;

public class BaseTest {
	DriverFactory df;
	public WebDriver d;
	public Properties prop;
	public HomePage hp;
	public MobilePage mp;
	public ProdDetailsPage pp;
	public CheckOutPage cp;
	public CompareProductsPage cpp;
	public CreateAccPage cap;
	public TVPage tp;
	public TVProdDetailsPage tpdp;
	public WishListPage wlp;
	public LoginPage lp;
	public ShareWishListPage swp;
	public DashBoardPage dbp;
	
	
	
	
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
