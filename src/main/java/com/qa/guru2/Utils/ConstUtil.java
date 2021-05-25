package com.qa.guru2.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstUtil {
	public static String HOMEPAGE_TITLE="Home page";
	public static String MOBILEPAGE_TITLE="Mobile";
	public static String MOBILEPAGE_HEADER="MOBILE";
	public static List<String> MOBILEPAGE_SORTBYNAME_LIST_EXP=Arrays.asList("IPHONE","SAMSUNG GALAXY","SONY XPERIA");
	public static final List<String> MOBILEPAGE_SORTBYPRICE_LIST_EXP = Arrays.asList("[0-10000]+");
	public static final String COMPAREWINDOW_HEADER ="COMPARE PRODUCTS";
	
	//ProdInfo Page
	public static String PRODINFOPAGE_PRODHEADER="SONY XPERIA";
	public static String PRODINFOPAGE_PRICE="$100.00";
	//checkout page
	public static final String CHECKOUTPAGE_ERROR = "Some of the products cannot be ordered in requested quantity.";
	public static final String CHECKOUTPAGE_ERROR_SONY = "* The maximum quantity allowed for purchase is 500.";
	public static final String CHECKOUTPAGE_EMPTY_CART= "SHOPPING CART IS EMPTY";
	public static final String TESTDATA_EXCEL_PATH = "./src/test/resources/testData/GuruMobileTVTestData.xlsx";
	public static final String TESTDATA_EXCEL_SHEETNAME_MULTIPLE = "def";
	public static final String TESTDATA_EXCEL_SHEETNAME_SINGLE = "sin";
	public static final String REGISTER_FAIL_MSG = "There is already an account with this email address. If you are sure that it is your email address, ";
	//acc create error
	//tv
	
	public static final List<String> TVPAGE_TV_LIST= Arrays.asList("LG LCD, SAMSUNG LCD");
	public static final String SAMSUNG_TV_HEADER="SAMSUNG LCD";
	public static final List<String> LEFT_PANEL_LIST=Arrays.asList("ACCOUNT INFORMATION","ACCOUNT INFORMATION","ADDRESS BOOK","MY ORDERS","BILLING AGREEMENTS","RECURRING PROFILES","MY PRODUCT REVIEWS","MY WISHLIST","MY APPLICATIONS","NEWSLETTER SUBSCRIPTIONS","MY DOWNLOADABLE PRODUCTS");
	
	//
	public static final String SHOPPINGCARTPAGE_FLAT_RATE="Flat Rate";		
	
			
			
			
			

}
