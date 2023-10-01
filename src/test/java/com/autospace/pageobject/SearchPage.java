package com.autospace.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.autospace.common.BaseClass;

public class SearchPage extends BaseClass {
	
	String searchBoxLocator = "//input[@id='searchBox']";
	String searchButtonLocator = "//*[@id='basic-addon2']";
	String booksTitleLocator = "//*[@class='action-buttons']//a";
	
	public void searchByBookTitle(String searchText) throws InterruptedException {
		
		WebElement searchBox = driver.findElement(By.xpath(searchBoxLocator));
		searchBox.sendKeys(searchText);
		Thread.sleep(2000);
		 
		WebElement searchButton = driver.findElement(By.xpath(searchButtonLocator));
		searchButton.click();
		 
		Thread.sleep(2000);
		 
	}
	
	
	public void verifyBookTitle(String searchText) throws InterruptedException {
		
		 
		List<WebElement> bookNames = driver.findElements(By.xpath(booksTitleLocator));
		 
		for(WebElement book : bookNames) {
			 
			System.out.println(book.getText());
			Assert.assertTrue(book.getText().contains(searchText));
			 
		}
	}

}
