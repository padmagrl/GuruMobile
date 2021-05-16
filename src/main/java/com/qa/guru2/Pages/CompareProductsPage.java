package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class CompareProductsPage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By CompareTwoProductsHeader = By.xpath("//h1[.='Compare Products']");

//2
	public CompareProductsPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public String verifyCompareTwoPoductsWindowHeader() {
		return eu.doGetText(CompareTwoProductsHeader);
	}

}
