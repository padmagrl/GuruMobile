package com.qa.guru2.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class HomePage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By mobileLink = By.xpath("//a[.='Mobile']");
	private By tvLink = By.xpath("//a[.='TV']");
	private By accountLink = By.xpath("//a/span[.='Account']");
	private By MyAccount = By.xpath("(//a[.='My Account'])[1]");
	private By accountHoverElts = By.xpath("(//div[@class='links'])[1]//li");
	private By CreateAccount = By.xpath("//a[@title='Create an Account']");
	

	// 2
	public HomePage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public String getHomePageTitle() {
		return eu.getPageTitle();
	}

	public MobilePage doClickMobile() {
		eu.doClick(mobileLink);
		return new MobilePage(d);
	}

	public void doClickMyAccountFromAccountMenu(String itemToClick) {
		eu.doClick(accountLink);
		// eu.doClickItemFromList(accountHoverElts, itemToClick);
		eu.doClickItemFromListWithFlash(accountHoverElts, itemToClick);
	}

	public LoginPage doClickLogInFromAccountMenu() {
		eu.doClick(accountLink);
		eu.doClickItemFromListWithFlash(accountHoverElts, "Log In");
		return new LoginPage(d);
	}

	public void doClickItemFromAccountMenuWithOptions(String itemToClick) {

		eu.doClick(accountLink);
		List<WebElement> li = eu.findElts(accountHoverElts);
		for (WebElement e : li) {
			if (e.getText().contains(itemToClick)) {

				e.click();
				break;

			}

		}

	}

	public CreateAccPage doClickCreateAccount() {
		eu.doClick(CreateAccount);
		return new CreateAccPage(d);
	}

	// ************TV ****
	public TVPage doClickTV() {
		eu.doClick(tvLink);
		return new TVPage(d);
	}
	
}
