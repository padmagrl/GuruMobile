package com.qa.guru2.Tests;

import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class OrderIDPageTest extends BaseTest {
	@Test
	public void orderIDTest()
	{
		lp=hp.doClickLogInFromAccountMenu();
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		wlp=dbp.clickMyWishlistFromLeftPanel();
		scp=wlp.addToCartFromWishList();
		cp2=scp.clickProceedToCheckOut("United States", "Texas", "5044");
		op=cp2.doCompleteCheckOutSteps();
		String msg=op.getOrderReceivedMsG();
		
		System.out.println(msg);
		String x=op.getOrderID();
		System.out.println(x);
		System.out.println(op.getonlyOrderID());
		
		
		
	}

}
