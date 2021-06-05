package com.qa.guru2.TestCases;

import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class Day08TestCaseFlow extends BaseTest {
	@Test
	public void day8Test() throws InterruptedException {
		lp = hp.doClickLogInFromAccountMenu();
		dbp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		mop = dbp.clickMyOrdersFromLeftPanel();
		scp = mop.clickReOderOFOrderNo("100014231");
		cp2 = scp.checkOutDirect();
		op = cp2.docompleteDirectCheckOut();
		String x = op.getjustOrderID();
		System.out.println("orderID->" + x);
	}

}
