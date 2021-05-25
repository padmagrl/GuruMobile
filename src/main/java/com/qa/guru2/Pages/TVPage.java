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
	private By samsungTV = By.xpath("//img[@alt='Samsung LCD']");
	private By TVheader = By.xpath("//h1[.='TV']");

	// 2
	public TVPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public List<String> getNamesOFListOFTVs() {
		return eu.getEltTextList(tvText);

	}

	public TVProdDetailsPage doClickOnSpecificTVFromOneOfImgs(String altVal, String srcVal) {
		List<WebElement> li = eu.waitForVisibilityOfELtsLocatedFluent(tvImgs, 20, 5);
		for (WebElement e : li) {
			if ((e.getAttribute("alt").contains(altVal)) && (!e.getAttribute("src").contains(srcVal))) {
				e.click();

				break;
			}

		}
		return new TVProdDetailsPage(d);
	}

	public TVProdDetailsPage doClickOnSAMSUNG() {
		System.out.println(eu.doGetText(TVheader));
		eu.waitForELtPresent(samsungTV, 20).click();
		return new TVProdDetailsPage(d);
	}

}
