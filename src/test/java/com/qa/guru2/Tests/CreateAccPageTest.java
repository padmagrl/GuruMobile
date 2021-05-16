package com.qa.guru2.Tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.ExcelUtil;

public class CreateAccPageTest extends BaseTest {
	@BeforeClass
	public void accPageSetUp() {
		hp.doClickMyAccountFromAccountMenu("My Account");
		cap = hp.doClickCreateAccount();

	}

	@DataProvider(name="multiple data")
	public Object[][] getRegTestDataMultiple() {
		return ExcelUtil.getTestData(ConstUtil.TESTDATA_EXCEL_PATH, ConstUtil.TESTDATA_EXCEL_SHEETNAME_MULTIPLE);
	}
	@DataProvider(name="single data")
	public Object[][] getRegTestDataSingle() {
		return ExcelUtil.getTestData(ConstUtil.TESTDATA_EXCEL_PATH, ConstUtil.TESTDATA_EXCEL_SHEETNAME_SINGLE);
	}

	public String getRandomEmail() {
		Random r = new Random();
		String email = "mala" + r.nextInt(100) + "@gmail.com";
		return email;
	}

	@Test(dataProvider="multiple data")
	public void CreateAnAccountWithMultipleDataTest(String firstname, String middlename, String lastname, String password,
			String subscribe) {
		boolean b=cap.doCreateAnAccountWithMultipleData(firstname, middlename, lastname, getRandomEmail(), password, subscribe);
		System.out.println(b);
		Assert.assertTrue(b);
	}
	@Test(dataProvider="single data")
	public void CreateAnAccountWithSingleDataTest(String firstname, String middlename, String lastname, String password,
			String subscribe) {
		boolean b=cap.doCreateAnAccount(firstname, middlename, lastname, getRandomEmail(), password, subscribe);
		System.out.println(b);
		Assert.assertTrue(b);
	}

}
