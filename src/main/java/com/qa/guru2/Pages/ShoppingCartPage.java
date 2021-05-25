package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.EltUtil;

public class ShoppingCartPage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By ShoppingCartHeader = By.xpath("//h1[.='Shopping Cart']");
	private By ShoppingCartMSG = By.xpath("//span[contains(.,'was added to your shopping cart')]");
	private By prodName = By.xpath("(//*[@class='product-name']/a)[1]");
	private By proceedToCheckOut = By.xpath("(//button[@title='Proceed to Checkout'])[2]");
	private By estimate = By.xpath("//button[@title='Estimate']");
	private By country = By.xpath("//select[@id='country']");
	private By state = By.xpath("//select[@id='region_id']");
	private By postCode = By.xpath("//input[@id='postcode']");
	private By flatRateText = By.xpath("//dt[.='Flat Rate']");
	private By flatRateRadio = By.xpath("//input[@id='s_method_flatrate_flatrate']");
	private By updateTotal = By.xpath("//button[@title='Update Total']");
	private By shippingandHandlingText = By.xpath("//td[contains(.,'Shipping & Handling (Flat Rate - Fixed)')]");
	private By priceElts = By.xpath("//td[@class='a-right']");

	// 2
	public ShoppingCartPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public String getShoppingCartHeader() {
		return eu.doGetText(ShoppingCartHeader);
	}

	public String getProdNameInTheCart() {
		return eu.doGetText(prodName);
	}

	public String getSuccessMsgOFShoppingCart() {
		String x2 = getProdNameInTheCart();
		String x1 = eu.doGetText(ShoppingCartMSG);
		String msg = x1 + x2;
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(msg);
		return msg;
	}

	public void clickEstimate() {
		eu.doClick(estimate);
	}

	public CheckOutPage2 clickProceedToCheckOut(String cou, String st, String zip) {
		eu.doSelectDropDownValueFromOptions(country, cou);
		eu.doSelectDropDownValueFromOptions(state, st);
		eu.doSendkeys(postCode, zip);
		eu.doClick(estimate);
		String act = eu.doGetText(flatRateText);

		if (act.equals(ConstUtil.SHOPPINGCARTPAGE_FLAT_RATE)) {
			eu.doClick(flatRateRadio);
		} 
		else {
			System.out.println("enter required fields and click estimate button");
			eu.doClick(estimate);
		}
		eu.doClick(updateTotal);
		eu.doClick(proceedToCheckOut);
		return new CheckOutPage2(d);

	}

}
