package com.qa.guru2.TestCases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class Day02TestCaseFlow extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void comparePriceInMobilePageAndProdInfoPage()

	{
		// 2
		mp = hp.doClickMobile();
		// 3
		String mobilePagePrice = mp.getSonyXperiaPrice();
		System.out.println("mobilePagePrice " + mobilePagePrice);
		// 4
		pp = mp.doClickOnItem("Xperia");
		// 5
		String prodPagePrice = pp.getProdPrice();
		System.out.println("prodPagePrice " + prodPagePrice);
		// 6
		try {
			
		
		softAssert.assertEquals(mobilePagePrice, prodPagePrice);

		softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
