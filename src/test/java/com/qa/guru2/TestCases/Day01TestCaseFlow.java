package com.qa.guru2.TestCases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class Day01TestCaseFlow extends BaseTest {
	SoftAssert softAssert=new SoftAssert() ;
	@Test
	public void verifySortedByName()
	
	{
		//2
		String actHomeTitle=hp.getHomePageTitle();
		System.out.println("actHomeTitle "+actHomeTitle);
		String expHomeTitle=ConstUtil.HOMEPAGE_TITLE;
		softAssert.assertEquals(actHomeTitle, expHomeTitle);
		//3
		mp=hp.doClickMobile();
		//4
		String actMobileHeader=mp.getmobilePageHeader();
		System.out.println("actMobileHeader "+actMobileHeader);
		String expMobileHeader=ConstUtil.MOBILEPAGE_HEADER;
		softAssert.assertEquals(actMobileHeader, expMobileHeader);
		// 4 5
		
		List<String> actList=mp.getProdListSortByNameText("Name");
		System.out.println("actList "+actList);
		List<String> expList=ConstUtil.MOBILEPAGE_SORTBYNAME_LIST_EXP;
		Collections.sort(expList);
		softAssert.assertEquals(actList, expList);
		softAssert.assertAll();
		
		
		
	}

}
