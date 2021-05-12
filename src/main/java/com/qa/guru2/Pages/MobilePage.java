package com.qa.guru2.Pages;

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
	private By addToCartOfXperia = By.xpath("//h2[contains(.,'Xperia')]//following-sibling::div[@class='actions']//button[@title='Add to Cart']");
	private By prodImgLinks = By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']//img");
	private By sonYXperiaPice = By.xpath("//h2[contains(.,'Sony')]//following-sibling::div//span[@class='price']");

//2
	public MobilePage(WebDriver d) {
		this.d = d;
		eu = new EltUtil(d);
	}

	// 3
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
	public String getSonyXperiaPrice()
	{
		return eu.findElt(sonYXperiaPice).getText();
	}
	public CheckOutPage doAddCartSonyXperia()
	{
		 eu.doClick(addToCartOfXperia);
		return new CheckOutPage(d);
	}

}
