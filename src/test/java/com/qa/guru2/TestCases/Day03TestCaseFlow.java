package com.qa.guru2.TestCases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class Day03TestCaseFlow extends BaseTest {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void comparePriceInMobilePageAndProdInfoPage()

	{
		// 2
		mp = hp.doClickMobile();
		// 3
		cp=mp.doAddCartSonyXperia();
		//4
		cp.doaddqty("1000");
		cp.doClickUpdate();
		//5
		 String act=cp.doGetErrorMsgForExtraQtyOFpRoductSony();
		 System.out.println("actual error msg for sony "+act);
		 String exp=ConstUtil.CHECKOUTPAGE_ERROR_SONY;
		 softAssert.assertEquals(act, exp);
		 //6
		 cp.doClickEmptyCart();
		 //7
		 String actEmpty=cp.doGetEmptyCartHeader();
		 System.out.println("actEmpty Header "+actEmpty);
		 String expEmpty=ConstUtil.CHECKOUTPAGE_EMPTY_CART;
		 softAssert.assertTrue(actEmpty.contains(expEmpty));
		 softAssert.assertAll();
	}

}
