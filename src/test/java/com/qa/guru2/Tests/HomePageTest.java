package com.qa.guru2.Tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.ExcelUtil;

public class HomePageTest extends BaseTest {
	@Test
	public void homePageTitleTest()
	{
		String act=hp.getHomePageTitle();
		System.out.println("Home Page Title "+act);
		String exp=ConstUtil.HOMEPAGE_TITLE;
		Assert.assertEquals(act, exp);
	}
	@Test
	public void clickMobileTest()
	{
		mp=hp.doClickMobile();
		Assert.assertEquals(mp.getMobilePageTitle(), ConstUtil.MOBILEPAGE_TITLE);
	}
	@Test
	public void ClickMyAccountFromAccountMenuTest()
	{
		hp.doClickMyAccountFromAccountMenu("My Account");
	}
	@Test
	public void ClickLogInFromAccountMenuTest()
	{
		hp.doClickMyAccountFromAccountMenu("Log In");
	}
	@Test
	public void doLoginTest()	{
		lp=hp.doClickLogInFromAccountMenu();
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

}
