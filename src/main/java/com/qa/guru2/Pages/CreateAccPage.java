package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class CreateAccPage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By firstname = By.id("firstname");
	private By middlename = By.id("middlename");
	private By lastname = By.id("lastname");
	private By email = By.id("email_address");
	private By password = By.id("password");
	private By confirmpassword = By.id("confirmation");
	private By subscribexpath = By.id("is_subscribed");
	private By regBut = By.xpath("//button[@title='Register']");
	private By regFailMsg = By.xpath(
			"//span[contains(.,'There is already an account with this email address. If you are sure that it is your email address')]");
	private By regSuccessMsg = By.xpath("//span[contains(.,'Thank you for registering with Main Website Store')]");
	private By welcomeMsg = By.xpath("//div[@class='welcome-msg']");

	// 2
	public CreateAccPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	public boolean doCreateAnAccount(String firstname, String middlename, String lastname, String email,
			String password, String subscribe) {
		eu.doSendkeys(this.firstname, firstname);
		eu.doSendkeys(this.middlename, middlename);
		eu.doSendkeys(this.lastname, lastname);
		eu.doSendkeys(this.email, email);
		eu.doSendkeys(this.password, password);
		eu.doSendkeys(this.confirmpassword, password);
		if (subscribe.equals("Yes")) {
			eu.doClick(subscribexpath);
		}
		eu.doClick(regBut);
		if (eu.findElt(regSuccessMsg).isDisplayed()) {
			System.out.println("success/welcome message " + eu.doGetText(welcomeMsg));
			return true;
		} else {
			System.out.println("error message " + eu.doGetText(regFailMsg));
			return false;
		}

	}

	public boolean doCreateAnAccountWithMultipleData(String firstname, String middlename, String lastname, String email,
			String password, String subscribe) {
		eu.doSendkeys(this.firstname, firstname);
		eu.doSendkeys(this.middlename, middlename);
		eu.doSendkeys(this.lastname, lastname);
		eu.doSendkeys(this.email, email);
		eu.doSendkeys(this.password, password);
		eu.doSendkeys(this.confirmpassword, password);
		if (subscribe.equals("Yes")) {
			eu.doClick(subscribexpath);
		}
		eu.doClick(regBut);
		if (eu.findElt(regSuccessMsg).isDisplayed()) {
			System.out.println("success/welcome message " + eu.doGetText(welcomeMsg));
			HomePage hp = new HomePage(d);
			CreateAccPage cap;
			hp.doClickMyAccountFromAccountMenu("Log Out");
			hp.doClickMyAccountFromAccountMenu("My Account");
			cap = hp.doClickCreateAccount();

			return true;
		} else {
			System.out.println("error message " + eu.doGetText(regFailMsg));
			return false;
		}

	}

}
