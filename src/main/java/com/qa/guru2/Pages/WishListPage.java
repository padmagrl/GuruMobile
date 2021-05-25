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
	private By addTocartButton = By.xpath("//button[@title='Add to Cart']");
	private By EmptyWishListMsg = By.xpath("//p[@class='wishlist-empty']");

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

	public ShoppingCartPage addToCartFromWishList() {
		eu.doClick(addTocartButton);
		return new ShoppingCartPage(d);
	}

	public ShoppingCartPage addToCartFromWishListWithEmptyWishList() {
		String head=eu.doGetText(WishListHeader);
		System.out.println("head "+head);
		
		String emptyMsg=eu.waitForELtVisible(EmptyWishListMsg, 10).getText();
		System.out.println(emptyMsg);
		
		if (emptyMsg.contains("no items")) {
			System.out.println("no items in wishlist");
			HomePage hp=new HomePage(d);
			TVPage tp;
			tp=hp.doClickTV();
			TVProdDetailsPage tpdp;
			tpdp=tp.doClickOnSAMSUNG();
			//tpdp=tp.doClickOnSpecificTVFromOneOfImgs("Samsung LCD","thumbnail");
			tpdp.clickAddToWishList("Samsung");
		}
		eu.doClick(addTocartButton);
		return new ShoppingCartPage(d);
	}

}
