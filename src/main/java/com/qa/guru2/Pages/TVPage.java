package com.qa.guru2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class TVPage {

	private WebDriver d;
	private EltUtil eu;
	// 1
	private By tvImgs = By.xpath("//a[@class='product-image']/img");
	private By tvText = By.xpath("//div[@class='product-info']/h2/a");

	// 2
	public TVPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public List<String> getNamesOFListOFTVs() {
		return eu.getEltTextList(tvText);

	}

	public TVProdDetailsPage doClickOnSpecificTVFromOneOfImgs(String altVal) {
		List<WebElement> li = eu.findElts(tvImgs);
		for (WebElement e : li) {
			if (e.getAttribute("alt").contains(altVal)) {
				e.click();
				break;
			}

		}
		return new TVProdDetailsPage(d);
	}

}
