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
		new DesiredCapabilities();
		// 1. Define Desired Capabilities
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.MAC);
		cap.setBrowserName("chrome");
		
		//Chrome Options definition
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String hubUrl = "http://192.168.1.8:4444/wd/hub";//wd - webdriver
		driver = new RemoteWebDriver(new URL(hubUrl), options);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void verifyTitle() {
		driver.get("http://www.freecrm.com");
		System.out.println(driver.getTitle());
	
		String actualTitle = driver.getTitle();
		
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		Assert.assertTrue(actualTitle.contains("Free CRM software"));
		
	}

}
