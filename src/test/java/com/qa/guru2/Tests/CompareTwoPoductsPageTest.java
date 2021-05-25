package com.qa.guru2.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class CompareTwoPoductsPageTest extends BaseTest {
	@BeforeClass
	public void compareSetUp() {
		mp = hp.doClickMobile();
	}
	@Test
	public void CompareTwoPoductsWindowTest()
	{
		mp.doClickAddToComapre("Sony");
		mp.doClickAddToComapre("IPhone");
		System.out.println("compared two phones1");
//		cpp=mp.doClickComapreButton();
//		String header=cpp.verifyCompareTwoPoductsWindowHeader();
//		System.out.println(header);
		
		
	}

}
