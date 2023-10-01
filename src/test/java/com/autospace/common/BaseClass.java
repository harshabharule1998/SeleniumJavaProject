package com.autospace.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BaseClass {
	
	public static WebDriver driver;
	String driverPath = "G://QaAutoSpace//chromedriver.exe";
	
	
	public void launchBrowser(String baseUrl) {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		  
		driver.get(baseUrl);
		
		
	}
	
	public void clickByJavascript(WebElement element) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		element.click();
	}
	
	
	public void quitBrowser() {
		driver.quit();  
		System.out.println("Browser quit");
	}

}
