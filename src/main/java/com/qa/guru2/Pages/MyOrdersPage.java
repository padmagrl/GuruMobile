package com.qa.guru2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class MyOrdersPage {
	private WebDriver d;
	private EltUtil eu;

	public MyOrdersPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}
	private By myOrdersHeader = By.xpath("//h1[.='My Orders']");
	private By viewOrderLinks = By.xpath("//a[.='View Order']");
	private By viewOrderWithOrderNumberLinks = By.xpath("//td[starts-with(.,'1000')]/..//a[.='View Order']");
	private By reOrderWithOrderNumberLinks = By.xpath("//td[starts-with(.,'1000')]/..//a[.='Reorder']");
	private By reOrderLinks = By.xpath("//a[.='//a[.='Reorder']']");

	public String getMyOrdersHeader() {
		return eu.doGetText(myOrdersHeader);
	}
	public By getXpathviewOrderWithOrderNumberLinks(String orderNumber)
	{
		By xpath=By.xpath("//td[starts-with(.,'"+orderNumber+"')]/..//a[.='View Order']");
		return xpath;
	}
	public By getXpathReorderWithOrderNoLinks(String orderNumber)
	{
		return By.xpath("//td[starts-with(.,'"+orderNumber+"')]/..//a[.='Reorder']");
	}
	public ViewOrderPage clickViewOderOFOrderNo(String OrderNo)
	{
		eu.findElt(getXpathviewOrderWithOrderNumberLinks(OrderNo)).click();
		return new ViewOrderPage(d) ;
	}
	public ShoppingCartPage clickReOderOFOrderNo(String OrderNo)
	{
		eu.findElt(getXpathReorderWithOrderNoLinks(OrderNo)).click();
		return new ShoppingCartPage(d) ;
	}

}
