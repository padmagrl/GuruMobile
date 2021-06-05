package com.qa.guru2.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru2.Utils.EltUtil;

public class MobilePage {
	private WebDriver d;
	private EltUtil eu;
	// 1
	private By mobileHeading = By.xpath("//h1[.='Mobile']");
	private By sortByDropDown = By.xpath("(//select[@title='Sort By'])[1]");
	private By prodList = By.xpath("//li[@class='item last']//h2[@class='product-name']/a");
	private By addToCart = By.xpath("//button[@title='Add to Cart']");
	private By addToCartOfXperia = By.xpath(
			"//h2[contains(.,'Xperia')]//following-sibling::div[@class='actions']//button[@title='Add to Cart']");
	private By addToCartOfIphone = By.xpath(
			"//h2[contains(.,'phone')]//following-sibling::div[@class='actions']//button[@title='Add to Cart']");
	private By prodImgLinks = By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']//img");
	private By sonYXperiaPice = By.xpath("//h2[contains(.,'Sony')]//following-sibling::div//span[@class='price']");
	private By sonYXperiaAddToCompare = By.xpath("//a[contains(.,'Sony')]/../..//a[.='Add to Compare']");
	private By CompareButton = By.xpath("//span/span[.='Compare']");
	private By CompareTwoProductsHeader = By.xpath("//h1[.='Compare Products']");
	private By sonyText = By.xpath("//a[.='Sony Xperia']");
	private By sonyWindowText = By.xpath("(//div[contains(.,'this is Sony Xperia')])[2]");
	private By IPhoneText = By.xpath("//a[.='IPhone']");
	private By SamsungGalaxyText = By.xpath("//a[.='Samsung Galaxy']");

//2
	public MobilePage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
	// *******Xpath functions****
	public By getXpathOFPrice(String name) {
		By Price = By.xpath("//h2[contains(.,'" + name + "')]//following-sibling::div//span[@class='price']");
		return Price;
	}

	public By getXpathAddToCompare(String name) {
		By AddToCompare = By.xpath("//a[contains(.,'" + name + "')]/../..//a[.='Add to Compare']");
		return AddToCompare;
	}

	public By getXpathOFAddToCart(String name) {
		By addToCart = By.xpath(
				"//h2[contains(.,'"+name+"')]//following-sibling::div[@class='actions']//button[@title='Add to Cart']");
		return addToCart;
	}
	// *************************************

	public String getMobilePageTitle() {
		return eu.getPageTitle();
	}

	public String getmobilePageHeader() {
		return eu.doGetText(mobileHeading);
	}

	public void doSelectSortByName(String nameOption) {
		eu.doSelectDropDownValueFromOptions(sortByDropDown, nameOption);
	}

	public void doSelectSortByPrice(String priceOption) {
		eu.doSelectDropDownValueFromOptions(sortByDropDown, priceOption);
	}

	public List<String> getProdListSortByNameText(String nameOption) {
		eu.doSelectDropDownValueFromOptions(sortByDropDown, nameOption);
		List<String> li = eu.getEltTextList(prodList);
		return li;
	}

	public List<String> getProdListSortByPriceText(String priceOption) {
		eu.doSelectDropDownValueFromOptions(sortByDropDown, priceOption);
		List<String> li = eu.getEltTextList(prodList);
		return li;
	}

	public ProdDetailsPage doClickOnItem(String item) {
		List<WebElement> li = eu.findElts(prodImgLinks);
		for (WebElement e : li) {
			if (e.getAttribute("alt").contains(item)) {
				e.click();
				break;
			}

		}
		return new ProdDetailsPage(d);
	}

	public String getSonyXperiaPrice() {
		return eu.findElt(sonYXperiaPice).getText();
	}

	public String getSonyXperiaPriceWithXpath(String name) {
		return eu.findElt(getXpathOFPrice(name)).getText();
	}

	public CheckOutPage doAddCartSonyXperia() {
		eu.doClick(addToCartOfXperia);
		return new CheckOutPage(d);
	}
	public ShoppingCartPage doAddCartIpone() {
		eu.doClick(getXpathOFAddToCart("IPhone"));
		return new ShoppingCartPage(d);
	}

	public CheckOutPage doAddCartSonyXperiaWithXpathFun(String name) {
		eu.doClick(getXpathOFAddToCart(name));
		return new CheckOutPage(d);
	}

	public void doClickAddToComapre(String name) {
		eu.doClick(getXpathAddToCompare(name));

	}

	public CompareProductsPage doClickComapreButton() {
		eu.doClick(CompareButton);
		return new CompareProductsPage(d);
	}

	public String clickCompareAndVerifyCompareWindowHeader() {
		String parent = eu.doGetParentWindowHandle();
		eu.doClick(CompareButton);
		eu.doSwitchChildWindow(parent);
		eu.justtakeScreenshot();
		String head = eu.doGetText(CompareTwoProductsHeader);
		//eu.doSwitchDefaultContent();
		return head;
	}
	public List<String> verifyCompareTwoPoductTexts() {
		String parent = eu.doGetParentWindowHandle();
		eu.doClick(CompareButton);
		eu.doSwitchChildWindow(parent);
		eu.maximizeWindow();
		eu.justtakeScreenshot();
		eu.doGetText(CompareTwoProductsHeader);
		System.out.println("sony win "+eu.doGetText(sonyWindowText));
		
		List<String> li=new ArrayList<String>();
	
		li.add(eu.waitForELtVisible(sonyText, 10).getText());
		li.add(eu.waitForELtVisible(IPhoneText, 10).getText());
		
		System.out.println("Child Window list "+li);
		eu.doSwitchDefaultContent();
		return li;
			
	}
	public String getSonyText()
	{
		return eu.doGetText(sonyText);
	}
	public String getIphoneText()
	{
		return eu.doGetText(IPhoneText);
	}
	public String getsonyWindowText()
	{
		return eu.doGetText(sonyWindowText);
	}

}
