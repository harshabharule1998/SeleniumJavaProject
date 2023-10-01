package com.autospace.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.autospace.common.BaseClass;

public class HomePageTest extends BaseClass {
  
  String baseUrl = "https://www.javatpoint.com/";
  
  
  @Test(groups = { "sanity" })
  public void verifyPageTitle() {
	 
	  
	  launchBrowser(baseUrl);
	  String pageTitle = driver.getTitle();
	  
	  String expectedTitle = "Tutorials List - Javatpoint";
	  
	  System.out.println(pageTitle);
	  
	  Assert.assertEquals(pageTitle, expectedTitle);
	  
  }
  
  
  @AfterTest  
	public void afterTest() {  
		driver.quit();  
		System.out.println("After test");  
	}
  
  
}
