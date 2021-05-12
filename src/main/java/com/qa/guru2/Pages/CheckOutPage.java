package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class CheckOutPage {
	private WebDriver d;
	private EltUtil eu;

	// 1
	private By quantityInput = By.xpath("//input[@title='Qty']");
	private By updateButton = By.xpath("//span/span[.='Update']");
	private By addToCartInCheckout = By.xpath("//span/span[.='Add to Cart']");
	private By errorForExtraQty = By.xpath("//span[.='Some of the products cannot be ordered in requested quantity.']");
	private By errorForExtraQtyofSony = By.xpath("//p[contains(.,'The maximum quantity allowed for purchase is')]");
	private By emptyCart = By.xpath("//span/span[.='Empty Cart']");
	private By shoppingCartEmptyHeader = By.xpath("//h1[.='Shopping Cart is Empty']");

//2
	public CheckOutPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}
	//3
	public void doaddqty(String qty)
	{
		eu.doSendkeys(quantityInput, qty);
	}
	public void doClickUpdate()
	{
		eu.doClick(updateButton);
	}
	public String doGetErroHeaderForExtraQty()
	{
		return eu.doGetText(errorForExtraQty);
	}
	public String doGetErrorMsgForExtraQtyOFpRoductSony()
	{
		return eu.doGetText(errorForExtraQtyofSony);
	}
	public void doClickEmptyCart()
	{
		eu.doClick(emptyCart);
	}
	public String doGetEmptyCartHeader()
	{
		return eu.doGetText(shoppingCartEmptyHeader);
	}

}
