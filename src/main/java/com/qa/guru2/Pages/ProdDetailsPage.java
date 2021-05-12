package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class ProdDetailsPage {
	private WebDriver d;
	private EltUtil eu;
	//1
	private By prodHeader=By.xpath("//div[@class='product-name']/span");
	private By prodPrice=By.xpath("//span[@class='price']");
//2
	public ProdDetailsPage(WebDriver d) {
		this.d=d;
		eu=new EltUtil(d);
	}
	//3
	public String getProdHeader()
	{
		return eu.doGetText(prodHeader);
	}
	public String getProdPrice()
	{
		return eu.doGetText(prodPrice);
	}

}
