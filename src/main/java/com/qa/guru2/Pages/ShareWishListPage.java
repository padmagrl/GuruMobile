package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class ShareWishListPage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By emailTextarea = By.xpath("//textarea[@name='emails']");
	private By msgTextarea = By.xpath("//textarea[@name='message']");
	private By shareWishList = By.xpath("//button[@title='Share Wishlist']");
	private By WishListSharedMsg = By.xpath("//span[.='Your Wishlist has been shared.']");

//2
	public ShareWishListPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public boolean doShareWishList(String email, String msg) {
		eu.doSendkeys(emailTextarea, email);
		eu.doSendkeys(msgTextarea, msg);
		eu.doClick(shareWishList);
		String sucMsg = eu.doGetText(WishListSharedMsg);
		System.out.println("sucMsg "+sucMsg);
		if (eu.findElt(WishListSharedMsg).isDisplayed())
			return true;
		else
			return false;
	}

}
