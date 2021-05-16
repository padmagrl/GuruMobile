package com.qa.guru2.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class DashBoardPage {
	private WebDriver d;
	private EltUtil eu;

	// 1
	private By succMsg = By.xpath("//span[.='Thank you for registering with Main Website Store.']");
	private By welcomeMsg = By.xpath("//div[@class='welcome-msg']");
	private By leftPanelLinks = By.xpath("//div[@class='block-content']//a");

	// 2
	public DashBoardPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public ArrayList<String> leftPaneLinksList() {
		List<WebElement> li = eu.findElts(leftPanelLinks);
		ArrayList<String> textList = new ArrayList<String>();
		for (WebElement e : li) {
			textList.add(e.getText());
		}
		return textList;
	}

}
