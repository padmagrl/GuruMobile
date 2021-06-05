package com.qa.guru2.Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru2.Utils.ConstUtil;
import com.qa.guru2.Utils.EltUtil;

public class ShoppingCartPage {
	private WebDriver d;
	private EltUtil eu;

	// 1
	private By ShoppingCartHeader = By.xpath("//h1[.='Shopping Cart']");
	private By ShoppingCartMSG = By.xpath("//span[contains(.,'was added to your shopping cart')]");
	private By prodName = By.xpath("(//*[@class='product-name']/a)[1]");
	private By proceedToCheckOut = By.xpath("(//button[@title='Proceed to Checkout'])[2]");
	private By estimate = By.xpath("//button[@title='Estimate']");
	private By country = By.xpath("//select[@id='country']");
	private By state = By.xpath("//select[@id='region_id']");
	private By postCode = By.xpath("//input[@id='postcode']");
	private By flatRateText = By.xpath("//dt[.='Flat Rate']");
	private By flatRateRadio = By.xpath("//input[@id='s_method_flatrate_flatrate']");
	private By updateTotal = By.xpath("//button[@title='Update Total']");
	private By shippingandHandlingText = By.xpath("//td[contains(.,'Shipping & Handling (Flat Rate - Fixed)')]");
	private By priceElts = By.xpath("//td[@class='a-right']");

	private By grandTotalPrice = By.xpath("//strong[.='Grand Total']/..//following-sibling::td//span[@class='price']");
	private By qty = By
			.xpath("//a[@class='product-image' and contains(@title,'Samsung LCD')]/../..//input[@title='Qty']");
	private By update = By.xpath(
			"//a[@class='product-image' and contains(@title,'Samsung LCD')]/../..//input[@title='Qty']/..//span/span[.='Update']");
	private By couponCode = By.xpath("//input[@name='coupon_code']");
	private By couponCodeApply = By.xpath("//button[@title='Apply']");
	private By couponCodeApplySuccessMsg = By.xpath("//span[contains(.,'applied')]");
	private By discountLabel = By.xpath("//td[contains(.,'Discount (GURU50)')]");
	private By subtotalLabel = By.xpath("//td[contains(.,'Subtotal')]");
	private By subtotalVal = By.xpath("//td[contains(.,'Subtotal')]//following-sibling::td/span");
	private By grandTotalLabel = By.xpath("//strong[.='Grand Total']");
	private By discountVal = By.xpath("//td[contains(.,'Discount (GURU50)')]//following-sibling::td/span");
	private By grandTotalVal = By.xpath("//strong[.='Grand Total']/..//following-sibling::td//span[@class='price']");

	// 2
	public ShoppingCartPage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	public By getXpathofQty(String prodTitle) {
		return By.xpath(
				"//a[@class='product-image' and contains(@title,'" + prodTitle + "')]/../..//input[@title='Qty']");
	}

	public By getXpathofUpdate(String prodTitle) {
		return By.xpath("//a[@class='product-image' and contains(@title,'" + prodTitle
				+ "')]/../..//input[@title='Qty']/..//span/span[.='Update']");
	}

	// 3
	public String getShoppingCartHeader() {
		return eu.doGetText(ShoppingCartHeader);
	}

	public String getProdNameInTheCart() {
		return eu.doGetText(prodName);
	}

	public String getSuccessMsgOFShoppingCart() {
		String x2 = getProdNameInTheCart();
		String x1 = eu.doGetText(ShoppingCartMSG);
		String msg = x1 + x2;
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(msg);
		return msg;
	}

	public void clickEstimate() {
		eu.doClick(estimate);
	}

	public CheckOutPage2 clickProceedToCheckOut(String cou, String st, String zip) {
		eu.doSelectDropDownValueFromOptions(country, cou);
		eu.doSelectDropDownValueFromOptions(state, st);
		eu.doSendkeys(postCode, zip);
		eu.doClick(estimate);
		String act = eu.doGetText(flatRateText);

		if (act.equals(ConstUtil.SHOPPINGCARTPAGE_FLAT_RATE)) {
			eu.doClick(flatRateRadio);
		} else {
			System.out.println("enter required fields and click estimate button");
			eu.doClick(estimate);
		}
		eu.doClick(updateTotal);
		eu.doClick(proceedToCheckOut);
		return new CheckOutPage2(d);

	}

	public void clickQty(String prodTitle, String qtyVal) {
		eu.doSendkeys(getXpathofQty(prodTitle), qtyVal);
	}

	public void clickUpdate(String prodTitle) {
		eu.doClick(getXpathofUpdate(prodTitle));
	}

	public CheckOutPage2 checkOutDirect() {
		String grandtotalbefore = eu.doGetText(grandTotalPrice);

		System.out.println("grand total before update " + grandtotalbefore);
		clickQty("Samsung", "10");
		clickUpdate("Samsung");
		clickQty("LG", "15");
		clickUpdate("LG");
		String grandtotalafter = eu.doGetText(grandTotalPrice);
		System.out.println("grand total after update " + grandtotalafter);

		/*
		 * String befores = grandtotalbefore.substring(1, grandtotalbefore.length()-3);
		 * System.out.println("befores->"+befores); int
		 * beforei=Integer.parseInt(befores); System.out.println("beforei " + beforei);
		 * String afters = grandtotalafter.substring(1, grandtotalafter.length()-3); int
		 * afteri=Integer.parseInt(afters); System.out.println("afterf " + afteri); int
		 * diff=afteri-beforei; System.out.println("diff "+diff);
		 */

		if (grandtotalbefore.equals(grandtotalafter)) {
			System.out.println("no change in grand total");
		} else {
			System.out.println("change in grand total");
		}

		eu.doClick(proceedToCheckOut);

		return new CheckOutPage2(d);

	}

	public String couponCodeApply(String codeVal) {
		eu.doSendkeys(couponCode, "GURU50");
		eu.doClick(couponCodeApply);
		String x = eu.doGetText(couponCodeApplySuccessMsg);
		return x;
	}
	public Map<String, Double> checkDiscoutApplied() {
	Map<String, Double> map=new HashMap<String, Double>();
	//subtotal
	String subtotalLabelText=eu.doGetText(subtotalLabel).trim();
	System.out.println("subtotalLabelText "+subtotalLabelText);
	String subtotalValue=eu.doGetText(subtotalVal).trim();
	System.out.println("subtotalValue "+subtotalValue);
	String subtotalValueRemove$=subtotalValue.replaceAll("\\$", " ");
	String subtotalValueRemove$Comma=subtotalValueRemove$.replaceAll(",", "").trim();
		System.out.println("subtotalValueWithOut$Comma$trim$->"+subtotalValueRemove$Comma);
	double subtotal=Double.parseDouble(subtotalValueRemove$Comma);
	System.out.println("subtotal "+subtotal);
	
	
	//discount
	String discLabelText=eu.doGetText(discountLabel).trim();
	String discValue=eu.doGetText(discountVal).trim();
	String discValueWithOut$=discValue.substring(2, discValue.length()).trim();
	String discValueRemove$Comma=discValueWithOut$.replaceAll(",", "").trim();
	double discount=Double.parseDouble(discValueRemove$Comma);
	System.out.println("discount->"+discount);
	
	//grandtotal
	String grandTotalLabelText=eu.doGetText(grandTotalLabel).trim();
	String grandTotalValue=eu.doGetText(grandTotalVal).trim();
	String grandTotalValueWithOut$=grandTotalValue.substring(1, grandTotalValue.length()).trim();
	String grandTotalValueRemove$Comma=grandTotalValueWithOut$.replaceAll(",", "");
	double grandTotal=Double.parseDouble(grandTotalValueRemove$Comma);
	
	
	map.put(subtotalLabelText, subtotal);
	map.put(discLabelText, discount);
	map.put(grandTotalLabelText, grandTotal);
	return map;
	
	
	
			
		
	}

}
