package com.simplilearn.unittest.amazon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Amazon Homepage Test")
class AmazonHomepageTest {

	// step1: formulate a test domain url & driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/windows/geckodriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
	}

	@Test
	@DisplayName("Should validate Amazon Homepage title")
	void testAmazonHomePageTitle() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	@DisplayName("Should validate Amazon Homepage source url")
	public void testAmazonHomePageSourceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Test
	@DisplayName("Should validate Amazon Homepage for invalid title")
	public void testAmazonHomePageTitle2() {
		String expectedTitle = "OOnline SShopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertNotEquals(actualTitle, expectedTitle);
	}

}
