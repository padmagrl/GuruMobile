package com.qa.guru2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.EltUtil;

public class LoginPage extends CommonPage {
	// 1
	private By username = By.name("login[username]");
	private By password = By.name("login[password]");
	private By loginBut = By.xpath("//button[@title='Login']");
	// 2
	private WebDriver d;
	EltUtil eu;

	public LoginPage(WebDriver d) {
		this.d = d;
		eu=new EltUtil(d);
	}

	// 3
	public DashBoardPage doLogin(String username,String password)
	{
		eu.doSendkeys(this.username, username);
		eu.doSendkeys(this.password, password);
		eu.doClick(loginBut);
		return new DashBoardPage(d);
	}

}
