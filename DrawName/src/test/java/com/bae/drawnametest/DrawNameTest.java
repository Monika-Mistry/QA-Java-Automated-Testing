package com.bae.drawnametest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DrawNameTest {

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
	public static void init() {
		driver.manage().window().maximize();
		driver.get("https://www.youidraw.com/apps/painter/");
	}

}
