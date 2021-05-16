package com.qa.guru2.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class DashboardPageTest extends BaseTest {
	@BeforeClass
	public void bashboardSetup()
	
	{
		lp=hp.doClickLogInFromAccountMenu("Log In");
		dbp=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void leftPanelLinksTextTest()
	{
		ArrayList<String> actlist=dbp.leftPaneLinksList();
		for (String s : actlist) {
			System.out.println(s);
			
		}
		List<String> explist=ConstUtil.LEFT_PANEL_LIST;
		Collections.sort(actlist);
		Collections.sort(explist);
		Assert.assertEquals(actlist, explist);
		
	}

}
