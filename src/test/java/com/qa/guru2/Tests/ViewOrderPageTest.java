package com.qa.guru2.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class ViewOrderPageTest extends BaseTest{
	@BeforeClass
	public void getViewOrderPageSetup()
	{
		lp=hp.doClickLogInFromAccountMenu();
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		mop=dbp.clickMyOrdersFromLeftPanel();
		vop=mop.clickViewOderOFOrderNo("100014124");
		
	}
	@Test
	public void getViewOrderPageHeaderTest()
	{
		System.out.println(vop.viewOrderDetailsHeader());
		System.out.println(vop.getOrderNoFromviewOrderDetails());
	}
	

}
