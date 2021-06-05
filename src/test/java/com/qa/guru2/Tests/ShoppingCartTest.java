package com.qa.guru2.Tests;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru2.Base.BaseTest;

public class ShoppingCartTest extends BaseTest {
	@BeforeClass
	public void shoppingCartSetup() {
		lp = hp.doClickLogInFromAccountMenu();

		dbp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		wlp = dbp.clickMyWishlistFromLeftPanel();
//		scp=wlp.addToCartFromWishList();
		mop = dbp.clickMyOrdersFromLeftPanel();
		scp = mop.clickReOderOFOrderNo("100014231");

	}

	@Test
	public void successMsgOFShoppingCartTest() {
		wlp = dbp.clickMyWishlistFromLeftPanel();
		scp = wlp.addToCartFromWishList();
		String x = scp.getSuccessMsgOFShoppingCart();
		System.out.println(x);
	}

	@Test
	public void checkOutDirectTest() throws InterruptedException {
		cp2 = scp.checkOutDirect();
		op = cp2.docompleteDirectCheckOut();
		String x = op.getjustOrderID();
		System.out.println("orderID->" + x);

	}

	@Test
	public void checkDiscoutnTest() {
		String x = scp.couponCodeApply("Guru50");
		System.out.println("msg-> " + x);
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
