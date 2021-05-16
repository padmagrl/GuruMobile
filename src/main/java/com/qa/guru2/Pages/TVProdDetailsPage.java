package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class TVProdDetailsPage {
	private WebDriver d;
	private EltUtil eu;
	//
	private By prodHeadersamsung=By.xpath("//span[contains(.,'Samsung')]");
	private By addToWishList=By.xpath("//a[.='Add to Wishlist']");
	private By addToWishListSamsungLCD=By.xpath("//h1[.='Samsung LCD']/../../following-sibling::div//a[.='Add to Wishlist']");
	private By addToCompareSamsungLCD=By.xpath("//h1[.='Samsung LCD']/../../following-sibling::div//a[.='Add to Compare']");

	public TVProdDetailsPage(WebDriver d) {
		this.d=d;
		eu=new EltUtil(d);
	}
	//xpath meth
	public By getProdHeaderXpath(String name)
	{
		By xpath=By.xpath("//span[contains(.,'"+name+"')]");
		return xpath;
	}
	public By getAddToWishListXpath(String name)
	{
		By xpath=By.xpath("//h1[contains(.,'"+name+"')]/../../following-sibling::div//a[.='Add to Wishlist']");
		return xpath;
	}
	public By getAddToComapreXpath(String name)
	{
		By xpath=By.xpath("//h1[contains(.,'"+name+"')]/../../following-sibling::div//a[.='Add to Compare']");
		return xpath;
	}
	public WishListPage clickAddToWishList(String name)
	{
		eu.doClick(getAddToWishListXpath(name));
		return new WishListPage(d) ;
	}
	public String getProdHeader(String name)
	{
		return eu.doGetText(getProdHeaderXpath(name));
	}

	

}
