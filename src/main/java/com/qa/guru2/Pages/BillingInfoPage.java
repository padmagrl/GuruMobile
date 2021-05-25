package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class BillingInfoPage {
	private WebDriver d;
	private EltUtil eu;

	public BillingInfoPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}
	//1
	private By address=By.xpath("//input[@id='billing:street1']");
	private By city=By.xpath("//input[@id='billing:city']");
	private By stateDD=By.xpath("//select[@id='billing:region_id']");
	
	private By Zip=By.xpath("//input[@id='billing:postcode']");
	private By countryDD=By.xpath("//select[@id='billing:country_id']");
	private By telephone=By.xpath("//input[@id='billing:telephone']");
	private By Continue1=By.xpath("//button[@onclick='billing.save()']");
	private By ShippingMethContinue2=By.xpath("//button[@onclick='shippingMethod.save()']");
	private By paymentContinue3=By.xpath("//button[@onclick='payment.save()']");
	private By paymentRadios=By.xpath("//dl[@id='checkout-payment-method-load']//input[@type='radio']");
	private By MoneyOrderpayment=By.xpath("//input[@id='p_method_checkmo']");
	private By placeOrder=By.xpath("//button[@title='Place Order']");
	private By orderID=By.xpath("//p[contains(.,'Your order # is: ')]");
	

}
//3


