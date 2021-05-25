package com.qa.guru2.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.guru2.Factory.DriverFactory;
import com.qa.guru2.Pages.BillingInfoPage;
import com.qa.guru2.Pages.CheckOutPage;
import com.qa.guru2.Pages.CheckOutPage2;
import com.qa.guru2.Pages.CompareProductsPage;
import com.qa.guru2.Pages.CreateAccPage;
import com.qa.guru2.Pages.DashBoardPage;
import com.qa.guru2.Pages.HomePage;
import com.qa.guru2.Pages.LoginPage;
import com.qa.guru2.Pages.MobilePage;
import com.qa.guru2.Pages.MyOrdersPage;
import com.qa.guru2.Pages.OrderIDPage;
import com.qa.guru2.Pages.ProdDetailsPage;
import com.qa.guru2.Pages.ShareWishListPage;
import com.qa.guru2.Pages.ShoppingCartPage;
import com.qa.guru2.Pages.TVPage;
import com.qa.guru2.Pages.TVProdDetailsPage;
import com.qa.guru2.Pages.ViewOrderPage;
import com.qa.guru2.Pages.WishListPage;

public class BaseTest {
	DriverFactory df;
	public WebDriver d;
	public Properties prop;
	public BillingInfoPage bip;
	public CheckOutPage cp;
	public CheckOutPage2 cp2;
	public CompareProductsPage cpp;
	public CreateAccPage cap;
	public DashBoardPage dbp;
	public HomePage hp;
	public LoginPage lp;
	public MobilePage mp;
	public MyOrdersPage mop;

	public OrderIDPage op;
	public ProdDetailsPage pp;
	public ShareWishListPage swp;
	public ShoppingCartPage scp;
	public TVPage tp;
	public TVProdDetailsPage tpdp;
	public ViewOrderPage vop;
	public WishListPage wlp;

	@BeforeClass
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		d = df.init_driver(prop);
		hp = new HomePage(d);
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
