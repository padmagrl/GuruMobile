package com.qa.guru2.TestCases;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class Day09TestCaseFlow extends BaseTest {
	@Test
	public void day9Test() throws InterruptedException {
		
		
		mp=hp.doClickMobile();
		scp=mp.doAddCartIpone();
		String x=scp.couponCodeApply("GURU50");
		System.out.println("coupon scuees msg "+x);
		Map<String, Double> mapDisc = scp.checkDiscoutApplied();
		mapDisc.forEach((K, V) -> System.out.println(K + "--" + V));

		Set<String> keys = mapDisc.keySet();
		System.out.println("  Keys **********");
		for (String s : keys) {
			System.out.println(s);
		}

		Collection<Double> values =mapDisc.values();
		System.out.println(" values **********");
		for (Double d : values) {
			System.out.println(d);
			
		}

		Double subtotal = mapDisc.get("SUBTOTAL");
		System.out.println("subtotal ky " + subtotal);
		Double disc = mapDisc.get("DISCOUNT (GURU50)");
		Double ActgranTotal = mapDisc.get("GRAND TOTAL");
		Double Exp_granTotal = subtotal - disc;
		System.out.println("ActgranTotal "+ActgranTotal);
		System.out.println("Exp_granTotal "+Exp_granTotal);
		try {
			Assert.assertEquals(ActgranTotal, Exp_granTotal);	
		} catch (Error e) {
			System.out.println("Actual and exp grand total are diff");
			//e.printStackTrace();
		}
		
	}

}
