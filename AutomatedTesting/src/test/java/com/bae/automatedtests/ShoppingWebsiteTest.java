package com.bae.automatedtests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingWebsiteTest {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

	@Before
	public void init() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void search() {
		WebElement searchBar = driver.findElement(By.name("search_query"));
		// WebElement searchBtn = driver.findElement(By.name("submit_search"));

		searchBar.click();
		assertTrue(searchBar.isEnabled());
	}
}
