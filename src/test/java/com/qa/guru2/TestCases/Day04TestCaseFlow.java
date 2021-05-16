package com.qa.guru2.TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.EltUtil;

public class Day04TestCaseFlow extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	

	@Test
	public void comparePriceInMobilePageAndProdInfoPage()

	{
		// 2 click on Mobile Menu
		mp = hp.doClickMobile();
		// 3 Click on Add to Compare for Sony,Iphone
		mp.doClickAddToComapre("Sony");
		mp.doClickAddToComapre("IPhone");
		//4 Click On Compare Button
		String header=mp.verifyCompareTwoPoductsWindowHeader();
		System.out.println("header "+header);
		
		//5 verify pop up window and check products are reflected in it
		//6 close pop up windows
		
	}

}
