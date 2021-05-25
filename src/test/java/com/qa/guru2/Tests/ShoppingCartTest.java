package com.qa.guru2.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class ShoppingCartTest extends BaseTest {
	@BeforeClass
	public void shoppingCartSetup() {
		lp=hp.doClickLogInFromAccountMenu();
		
		dbp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		wlp = dbp.clickMyWishlistFromLeftPanel();
		scp=wlp.addToCartFromWishList();
	}
	@Test
	public void successMsgOFShoppingCartTest()
	{
		String x=scp.getSuccessMsgOFShoppingCart();
		System.out.println(x);
	}
}
