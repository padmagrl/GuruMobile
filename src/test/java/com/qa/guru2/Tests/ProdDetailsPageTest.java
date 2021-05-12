package com.qa.guru2.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class ProdDetailsPageTest extends BaseTest {
	@BeforeClass
	public void prodDetailsSetUp()
	{
		mp=hp.doClickMobile();
		pp=mp.doClickOnItem("Xperia");
	}
	@Test
	public void prodHeaderOfProdDetailsTest()
	{
		String act=pp.getProdHeader();
		System.out.println("act prod header "+act);
		String exp=ConstUtil.PRODINFOPAGE_PRODHEADER;
		Assert.assertEquals(act, exp);
	}
	@Test
	public void prodPriceOfProdDetailsTest()
	{
		String act=pp.getProdPrice();
		System.out.println("act prod price "+act);
		String exp=ConstUtil.PRODINFOPAGE_PRICE;
		Assert.assertEquals(act, exp);
	}

}
