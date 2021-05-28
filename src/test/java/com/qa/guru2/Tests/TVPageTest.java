package com.qa.guru2.Tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;
import com.qa.guru2.Utils.ConstUtil;

public class TVPageTest extends BaseTest {
	@BeforeClass

	public void TVSetup() {
		tp = hp.doClickTV();
	}

	@Test(enabled=false)
	public void NamesOFListOFTVsTest() {
		List<String> actli = tp.getNamesOFListOFTVs();
		System.out.println(actli);
		List<String> expli = ConstUtil.TVPAGE_TV_LIST;
		System.out.println(expli);
		Collections.sort(expli);
		Collections.sort(actli);
		Assert.assertEquals(actli, expli);

	}

	@Test
	public void clickOnSpecificTVTest() {
		tp.doClickOnSpecificTVFromOneOfImgs("Samsung LCD","thumbnail");
	}

}
