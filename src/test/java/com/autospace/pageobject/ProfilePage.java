package com.autospace.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autospace.common.BaseClass;

public class ProfilePage extends BaseClass {
	
	String bookStoreButtonLocator = "//button[@id='gotoStore']";
	String searchBoxLocator = "//input[@id='searchBox']";
	
	public void gotoBookStore() throws InterruptedException {
		
		WebElement bookStoreButton = driver.findElement(By.xpath(bookStoreButtonLocator));		 
		clickByJavascript(bookStoreButton);
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchBoxLocator)));
	}

}
