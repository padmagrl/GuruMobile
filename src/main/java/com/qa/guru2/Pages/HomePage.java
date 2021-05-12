package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class HomePage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By mobileLink = By.xpath("//a[.='Mobile']");

	// 2
	public HomePage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}
	//3
	public String getHomePageTitle() {
		return eu.getPageTitle();
	}
	public MobilePage doClickMobile()
	{
		eu.doClick(mobileLink);
		return new MobilePage(d);
	}

}
