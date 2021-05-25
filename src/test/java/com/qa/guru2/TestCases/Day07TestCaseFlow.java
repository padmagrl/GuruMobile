package com.qa.guru2.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class Day07TestCaseFlow extends BaseTest {
	@Test
	public void orderIDTest()
	{
		lp=hp.doClickLogInFromAccountMenu();
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		mop=dbp.clickMyOrdersFromLeftPanel();
		vop=mop.clickViewOderOFOrderNo("100014124");
		System.out.println(vop.viewOrderDetailsHeader());
		System.out.println(vop.getOrderNoFromviewOrderDetails());
		lp=hp.doClickLogInFromAccountMenu();
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		wlp=dbp.clickMyWishlistFromLeftPanel();
		wlp.addToCartFromWishListWithEmptyWishList();
		
	}
}
