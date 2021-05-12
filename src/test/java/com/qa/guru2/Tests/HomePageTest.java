package com.qa.guru2.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

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

}
