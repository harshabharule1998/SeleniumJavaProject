package com.autospace.pageobject;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autospace.common.BaseClass;
import com.autospace.utils.ExcelReader;

public class LoginPage extends BaseClass {
	
	String userNameLocator = "//input[@id='userName']";
	String passwordLocator = "//input[@id='password']";
	String loginButtonLocator = "//button[@id='login']";
	String bookStoreButtonLocator = "//button[@id='gotoStore']";
	
	

	public void enterUserNameAndPassword() throws IOException {
		
		WebElement userName = driver.findElement(By.xpath(userNameLocator));
		WebElement password = driver.findElement(By.xpath(passwordLocator));
		
		ExcelReader reader = new ExcelReader();
		HashMap<String, String> credentials = reader.readUserCredentialsFromExcel();
		
		userName.sendKeys(credentials.get("id"));
		password.sendKeys(credentials.get("pass"));
		
	}
	
	public void submitLoginForm() throws InterruptedException {
		
		WebElement loginButton = driver.findElement(By.xpath(loginButtonLocator));
		clickByJavascript(loginButton);
	}
	
	public void verifyLoginSuccesfully() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bookStoreButtonLocator)));

	}
}
