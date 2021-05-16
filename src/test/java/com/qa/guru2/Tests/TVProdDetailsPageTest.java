package com.qa.guru2.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class TVProdDetailsPageTest extends BaseTest {
	@BeforeClass
	public void TvProdDetailsSetUp()
	{
		tp=hp.doClickTV();
		tpdp=tp.doClickOnSpecificTVFromOneOfImgs("Samsung LCD");
	}
	@Test
	public void samsungTvProdHeaderTest()
	
	{
		String header=tpdp.getProdHeader("Samsung");
		System.out.println(header);
	}
	@Test
	public void samsungTvAddWishListTest()
	
	{
		tpdp.clickAddToWishList("Samsung");
		
	}
	

}
