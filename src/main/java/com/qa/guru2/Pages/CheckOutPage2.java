package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class CheckOutPage2 {
	private WebDriver d;
	private EltUtil eu;

	public CheckOutPage2(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 1
	private By address = By.xpath("//input[@id='billing:street1']");
	private By city = By.xpath("//input[@id='billing:city']");
	private By stateDD = By.xpath("//select[@id='billing:region_id']");

	private By Zip = By.xpath("//input[@id='billing:postcode']");
	private By countryDD = By.xpath("//select[@id='billing:country_id']");
	private By telephone = By.xpath("//input[@id='billing:telephone']");
	private By Continue1 = By.xpath("//button[@onclick='billing.save()']");
	private By ShippingMethContinue2 = By.xpath("//button[@onclick='shipping.save()']");
	private By ShippingMethContinue3 = By.xpath("//button[@onclick='shippingMethod.save()']");
	private By paymentContinue3 = By.xpath("//button[@onclick='payment.save()']");
	private By paymentRadios = By.xpath("//dl[@id='checkout-payment-method-load']//input[@type='radio']");
	private By MoneyOrderpayment = By.xpath("//form[@id='co-payment-form']//input[@id='p_method_checkmo']");
	private By cccpayment = By.id("p_method_ccsave");
	private By placeOrder = By.xpath("//button[@title='Place Order']");
	private By orderID = By.xpath("//p[contains(.,'Your order # is: ')]");
	private By orderReceivedMsG = By.xpath("//h1[.='Your order has been received.']");

	private By shiptoiffaddrs = By.xpath("//input[@title='Ship to different address']");

//3
	public OrderIDPage doCompleteCheckOutSteps() {
		eu.doClick(Continue1);
		eu.doClick(ShippingMethContinue2);
		eu.waitForELtVisible(MoneyOrderpayment, 10).click();
		// eu.doClickItemFromListWithFlash(paymentRadios, "Check / Money order");
		// eu.waitForFrameAndSwitch("co-payment-form", 10);
		// eu.doClick(cccpayment);

		// eu.doSwitchDefaultContent();
		eu.doClick(paymentContinue3);
		eu.waitForELtVisible(placeOrder, 10).click();
		System.out.println("placeorder clicked");
//		String parent = eu.doGetParentWindowHandle();
//		eu.doSwitchChildWindow(parent);
//		String x = eu.doGetText(orderReceivedMsG);
//		System.out.println(x);
		return new OrderIDPage(d);
	}

	public String doCompleteCheckOutSteps2() {
		eu.doClick(Continue1);
		eu.waitForELtVisible(ShippingMethContinue2, 10).click();
		// eu.waitForELtVisible(ShippingMethContinue3,10).click();
		// eu.doClick(ShippingMethContinue2);
		eu.waitForELtVisible(MoneyOrderpayment, 20).click();
		// eu.doClickItemFromListWithFlash(paymentRadios, "Check / Money order");
		// eu.waitForFrameAndSwitch("co-payment-form", 10);
		// eu.doClick(cccpayment);

		// eu.doSwitchDefaultContent();
		eu.doClick(paymentContinue3);
		eu.waitForELtVisible(placeOrder, 10).click();
		System.out.println("placeorder clicked");
		String parent = eu.doGetParentWindowHandle();
		eu.doSwitchChildWindow(parent);
		String x = eu.doGetText(orderReceivedMsG);
		System.out.println(x);
		return x;

	}

	public OrderIDPage docompleteDirectCheckOut() throws InterruptedException {
		eu.doClick(Continue1);
		//eu.waitForELtVisible(ShippingMethContinue2, 10).click();
		eu.waitForELtVisible(ShippingMethContinue3, 10).click();
		eu.waitForELtVisible(MoneyOrderpayment, 20).click();
		eu.doClick(paymentContinue3);
		eu.waitForELtVisible(placeOrder, 10).click();
		System.out.println("placeorder clicked");
		Thread.sleep(15000);
		String parent = eu.doGetParentWindowHandle();
		eu.doSwitchChildWindow(parent);
		String x = eu.doGetText(orderReceivedMsG);
		System.out.println(x);

		return new OrderIDPage(d);
	}
}
