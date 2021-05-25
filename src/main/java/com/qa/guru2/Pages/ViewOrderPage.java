package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class ViewOrderPage {

	private WebDriver d;
	private EltUtil eu;

	public ViewOrderPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}
	
	
	private By OrderIDPendingHeader=By.xpath("//h1[contains(.,'Order #')]");
	
	
	public String viewOrderDetailsHeader()
	{
		return eu.waitForELtVisible(OrderIDPendingHeader, 10).getText();
		 //eu.doGetText(OrderIDPendingHeader);
		
	}
	public String getOrderNoFromviewOrderDetails()
	{
		String or= viewOrderDetailsHeader();
		String sub=or.substring(7,16);
		return sub;
	}

}
