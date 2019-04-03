package com.udemy.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeGridTest {

	private WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// 1. Define Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		cap.setPlatform(Platform.MAC);
		cap.setBrowserName("chrome");

		String hubUrl = "http://192.168.1.8:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubUrl), cap);
	}

	/*@AfterTest
	public void closeBrowser() {
		driver.quit();
	}*/

	@Test
	public void verifyTitle() {
		driver.get("http://www.freecrm.com");
		System.out.println(driver.getTitle());
		
		String expectedTitle = "Free CRM software in the cloud for sales and service";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}

}
