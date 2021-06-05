package com.qa.guru2.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class ReOrderPage {

	private WebDriver d;
	private EltUtil eu;

	public ReOrderPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

}
