package com.simplilearn.unittest.amazon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonLinkVerificationTest {

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
	@DisplayName("Should verify Amazon Deals link")
	public void linkTest1() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@Test
	@DisplayName("Should verify Amazon Mobiles link")
	public void linkTest2() throws InterruptedException {
		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));

		link.click();

		// add delay
		Thread.sleep(1000);

		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
}
