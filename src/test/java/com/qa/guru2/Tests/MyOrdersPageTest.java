package com.qa.guru2.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Pages.OrderIDPage;

public class MyOrdersPageTest extends BaseTest{
	@BeforeClass
	public void myOdersSetup()
	{
		lp=hp.doClickLogInFromAccountMenu();
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		mop=dbp.clickMyOrdersFromLeftPanel();
	}
	@Test
	public void myOrdersHeaderTest()
	{
		System.out.println(mop.getMyOrdersHeader());
	}
	@Test
	public void clickViewOderOFOrderNoTest()
	{
		System.out.println(mop.getMyOrdersHeader());
//		OrderIDPage od=new OrderIDPage(d);
//		String orderID=od.getjustOrderID();
//		mop.clickViewOderOFOrderNo(orderID);
		mop.clickViewOderOFOrderNo("100014124");
		System.out.println("clk");
	}

}
