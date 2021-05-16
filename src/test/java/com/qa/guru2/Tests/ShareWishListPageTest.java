package com.qa.guru2.Tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.ExcelUtil;

public class ShareWishListPageTest extends BaseTest {
	@BeforeClass
	public void shareWishListSetup() {

	}

	@DataProvider(name = "single data")
	public Object[][] getRegTestDataSingle() {
		return ExcelUtil.getTestData(ConstUtil.TESTDATA_EXCEL_PATH, ConstUtil.TESTDATA_EXCEL_SHEETNAME_SINGLE);
	}

	public String getRandomEmail() {
		Random r = new Random();
		String email = "mala" + r.nextInt(100) + "@gmail.com";
		return email;
	}

	@Test(dataProvider = "single data")
	public void shareWishListTest(String firstname, String middlename, String lastname, String password,
			String subscribe) {
		hp.doClickMyAccountFromAccountMenu("My Account");
		cap = hp.doClickCreateAccount();
		boolean b = cap.doCreateAnAccount(firstname, middlename, lastname, getRandomEmail(), password, subscribe);
		if (b) {
			System.out.println(b);
		} else {
			System.out.println("reg is not successful");
		}
		tp=hp.doClickTV();
		
		tpdp=tp.doClickOnSpecificTVFromOneOfImgs("Samsung");
		wlp=tpdp.clickAddToWishList("Samsung");
		swp=wlp.clickOnShareWishListFromWishListButtonsList();
		boolean b1=swp.doShareWishList("padmatest@gmail.com", "test");
		System.out.println(b1);

	}

}
