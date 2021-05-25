package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class OrderIDPage {
	private WebDriver d;
	private EltUtil eu;

	public OrderIDPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 1
	private By orderID = By.xpath("//p[contains(.,'Your order # is: ')]");
	private By orderReceivedMsG = By.xpath("//h1[.='Your order has been received.']");

	// 3
	public String getOrderID() {
		return eu.doGetText(orderID);
	}

	public String getOrderReceivedMsG() {
		return eu.waitForELtPresent(orderReceivedMsG, 20).getText();

		// return eu.doGetText(orderReceivedMsG);
	}

	public String getonlyOrderID() {
		String x = eu.waitForELtPresent(orderID, 20).getText();
		int i = x.indexOf('1');
		System.out.println("index of  1->" + i);
		System.out.println("len " + x.length());

		String[] parts = x.split(":");
		for (String s : parts) {
			System.out.println(s);
		}

		String part0 = parts[0].trim();
		String part1 = parts[1].trim();
		String part2 = part1.substring(part1.indexOf('1'), 9);

		System.out.println(part0 + "  " + part1);
		System.out.println("OrderID IS  ->" + part2 + "<-");
		System.out.println(part2.length());
		return part2;
	}

	public String getjustOrderID() {
		String x = eu.waitForELtPresent(orderID, 20).getText();
		String[] parts = x.split(":");
		String part1 = parts[1].trim();
		String part2 = part1.substring(part1.indexOf('1'), 9);

		return part2;
	}

}
