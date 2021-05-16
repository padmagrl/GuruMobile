package com.qa.guru2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class WishListPage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By WishListHeader = By.xpath("//div[@class='my-wishlist']//h1");
	private By WishListButtons = By.xpath("//div[@class='my-wishlist']//button");

//2
	public WishListPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public String getwishListHeader() {
		return eu.doGetText(WishListHeader);
	}

	public void clickOnButtonFromWishListButtonsList(String attVal) {
		List<WebElement> li = eu.findElts(WishListButtons);
		for (WebElement e : li) {
			if (e.getAttribute("title").contains(attVal)) {
				e.click();
				break;
			}

		}
	}
	public ShareWishListPage clickOnShareWishListFromWishListButtonsList() {
		List<WebElement> li = eu.findElts(WishListButtons);
		for (WebElement e : li) {
			if (e.getAttribute("title").contains("Share Wishlist")) {
				e.click();
				break;
			}

		}
		return new ShareWishListPage(d);
	}

}
