package com.autospace.tests;

import org.testng.annotations.Test;

import com.autospace.common.BaseClass;
import com.autospace.pageobject.LoginPage;
import com.autospace.pageobject.ProfilePage;
import com.autospace.pageobject.SearchPage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class LoginTest {
  
	String baseUrl = "https://demoqa.com/login";
	LoginPage loginPage;
	ProfilePage profilePage;
	SearchPage searchPage;
	
	@BeforeTest(alwaysRun = true)
	public void init() {
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		searchPage = new SearchPage(); 
		System.out.println("Before test");
	}
	
	  
	@Test(groups = { "smoke", "regression" })
	public void login() throws InterruptedException, IOException {
		
		 	 
		 loginPage.launchBrowser(baseUrl);
		 loginPage.enterUserNameAndPassword();
		 loginPage.submitLoginForm();
		 loginPage.verifyLoginSuccesfully();
		 
	}
	
	
	@Test(groups = { "regression" }, dependsOnMethods = { "login" })
	public void bookSearch() throws InterruptedException, IOException {
		
		 	 
		 loginPage.launchBrowser(baseUrl);
		 loginPage.enterUserNameAndPassword();
		 loginPage.submitLoginForm();
		 loginPage.verifyLoginSuccesfully();
		 
		 profilePage.gotoBookStore();
		 
		 searchPage.searchByBookTitle("JavaScript");
		 searchPage.verifyBookTitle("JavaScript");
		 
		 
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		profilePage.quitBrowser(); 
		System.out.println("After test");
	}
}
