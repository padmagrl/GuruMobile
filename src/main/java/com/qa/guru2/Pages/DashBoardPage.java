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
	private By dashBoardHeader = By.xpath("//h1[.='My Dashboard']");
	private By myWishList = By.xpath("//a[.='My Wishlist']");

	// 2
	public DashBoardPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public String getDashBoardHeader() {
		return eu.doGetText(dashBoardHeader);
	}

	public ArrayList<String> leftPaneLinksList() {
		List<WebElement> li = eu.findElts(leftPanelLinks);
		ArrayList<String> textList = new ArrayList<String>();
		for (WebElement e : li) {
			textList.add(e.getText());
		}
		return textList;
	}

	
	
	public WishListPage clickMyWishlistFromLeftPanel() {
		// eu.waitForELtVisible(myWishList, 10).click();
		eu.doClickItemFromListWithFlash(leftPanelLinks, "My Wishlist");
		// eu.doClick(myWishList);
		return new WishListPage(d);
	}
	// **********Left Panel Links Clicking*****************


	public DashBoardPage clickAccDashboardFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Account Dashboard");
		return new DashBoardPage(d);
	}

	public void clickAccInfoFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Account Information");
	}

	public void clickAdrsBookFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Address Book");
	}

	public MyOrdersPage clickMyOrdersFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "My Orders");
		return new MyOrdersPage(d);
	}

	public void clickBillingAgreementsBookFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Billing Agreements");
	}

	public void clickRecurringProfilesFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Recurring Profiles");
	}

	

	public void clickMyApplicationsFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "My Applications");
	}

	public void clickNewsletterSubscriptionsFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "Newsletter Subscriptions");
	}

	public void clickMyDownloadableProductsFromLeftPanel() {
		eu.doClickItemFromListWithFlash(leftPanelLinks, "My Downloadable Products");
	}
	// ************************
	

}
