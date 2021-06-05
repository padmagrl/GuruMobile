package com.qa.guru2.Solution;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day7b {
	private WebDriver driver;
	  private String baseUrl;
	  public String firstName = "BERRY";    // These testdata stuff will be placed    
	  public String lastName = "BERRYTEN";  // in a TestData EXCEL file at some stage
	  public String vEmail = "Berry.Berrysix@gmail.com";
	  public String vPW = "123456";
	  
	@BeforeTest
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    baseUrl = "http://live.demoguru99.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase7b() throws Exception {
		  
		  // Step 1. Go to http://live.demoguru99.com                                         
		    driver.get(baseUrl); 
		    
		    // Step 2. Click on My Account link
		    driver.findElement(By.linkText("MY ACCOUNT")).click();
		    
		    Thread.sleep(2000);  
		    
		    // switching to new window                                                    
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		    
		    // Step 3. Login in application using previously created credential 
		    driver.findElement(By.id("email")).clear();	   
		    driver.findElement(By.id("email")).sendKeys(vEmail); 
		    driver.findElement(By.id("pass")).clear();	    
		    driver.findElement(By.id("pass")).sendKeys(vPW);
		    driver.findElement(By.id("send2")).click();	 // this is the Login button   
		    
		    Thread.sleep(2000);  
		    
		    // switching to new window                                                                               
			    for (String handle : driver.getWindowHandles()) {
			    	driver.switchTo().window(handle);
			    	}
		  
			    // Step 4. Click on 'My Orders'
				// note: clicking My Orders at this point is not in the sequence,  in order to reach step 6,  
			    //          because immediately after logging in, it goes straight to display of Recent Orders page
				// driver.findElement(By.linkText("My Orders")).click();
					    
				// Step 5. Click on 'View Order' 
				// note: clicking View Order at this point is not in the sequence, in order to reach step 6, 
			    //		 because immediately after logging in, it goes straight to display of Recent Orders page
				// driver.findElement(By.linkText("View Order")).click();

				
			    //********************************************************************************************************	  
			    // Step 6. Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
			    // note: RECENT ORDERS page is displayed immediately after customer/user has logged in
			    
			    try {
			    	System.out.println(driver.findElement(By.cssSelector("h2")).getText());
			        assertEquals("RECENT ORDERS", driver.findElement(By.cssSelector("h2")).getText());
			        System.out.println("*** RECENT ORDERS is confirmed as the correct page to be in. ***");
			      } catch (Error e) {
			    	  System.out.println("*** RECENT ORDERS failed to get displayed on the page. ***");
			    	  e.printStackTrace();	
			      }
			    
			    try {
			    	assertEquals("Pending", driver.findElement(By.cssSelector("em")).getText());
			    	System.out.println("*** Status of Pending is correctly displayed for this recent order. ***");
			      } catch (Error e) {
			    	  System.out.println("*** Status of Pending failed to be confirmed for this recent order. ***");
			    	  e.printStackTrace();	
			      }
			    
		  
			    // Step 7. Click on 'Print Order' link
			    driver.findElement(By.linkText("VIEW ORDER")).click();
			    
			    Thread.sleep(2000);  
			    
			    // switching to new window                                                                               
			    for (String handle : driver.getWindowHandles()) {
			    	driver.switchTo().window(handle);
			    	}
			    			    
			    driver.findElement(By.linkText("Print Order")).click();
			    
			    Thread.sleep(2000);  
		  
			    // Step 8. Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.  
			    // note:  There is no "Change...." link 
		
	   
			    // Step 9. Click on 'Save' button and save the file in some location.
			    // note: unable to find this Save button
		  
			    // Step 10.Verify Order is saved as PDF
			    // unable to perform any verification because there is no option to save as PDF
		  
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	  }

}
