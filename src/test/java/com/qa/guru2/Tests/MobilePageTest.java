package com.qa.guru2.Tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class MobilePageTest extends BaseTest {
	@BeforeClass
	public void mobilePageSetup()
	{
		mp=hp.doClickMobile();
	}
	@Test
	public void mobilePageTitleTest()
	{
		String act=mp.getMobilePageTitle();
		System.out.println("actual MobilePageTitle "+act);
		String exp=ConstUtil.MOBILEPAGE_TITLE;
		Assert.assertEquals(act, exp);
	}
	@Test
	public void mobilePageHeaderTest()
	{
		String act=mp.getmobilePageHeader();
		System.out.println("actual MobilePage Header "+act);
		String exp=ConstUtil.MOBILEPAGE_HEADER;
		Assert.assertEquals(act, exp);
	}
	@Test
	public void SelectSortByNameTest() {
		mp.doSelectSortByName("Name");
		
	}
	@Test
	public void prodListSortByNameTest()
	{
		List<String> act=mp.getProdListSortByNameText("Name");
		for (String s : act) {
			System.out.println(s);
		}
		System.out.println("actual mobiles list sorted by name "+act);
		List<String> exp=ConstUtil.MOBILEPAGE_SORTBYNAME_LIST_EXP;
		Collections.sort(exp);
		Assert.assertEquals(act, exp);
		
	}
	@Test
	public void prodListSortByPriceTest()
	{
		List<String> act=mp.getProdListSortByPriceText("Price");
		for (String s : act) {
			System.out.println("actual mobiles list sorted by price  "+s);
		}
		//System.out.println("actual mobiles list sorted by price  "+act);
		List<String> exp=ConstUtil.MOBILEPAGE_SORTBYPRICE_LIST_EXP;
		Collections.sort(exp);
		Assert.assertEquals(act, exp);
		
	}

}
