package com.bae.drawnametest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrawNameTest {

	public static WebDriver driver;
	public Actions action;

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
		driver.get("https://www.youidraw.com/apps/painter/");
		action = new Actions(driver);

	}

	@Ignore
	@Test
	public void changeBrush() throws InterruptedException {
		WebElement brushType = driver.findElement(By.id("cmbPencil"));
		WebElement fur = driver.findElement(By.xpath("//option[@value=\"Fur\"]"));
		action.click(brushType).click(fur).perform();

		Thread.sleep(2000);
	}

	@Ignore
	@Test
	public void drawM() throws InterruptedException {

		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 50).moveByOffset(50, -50)
				.moveByOffset(0, 100).perform();
		Thread.sleep(2000);
	}

	@Ignore
	@Test
	public void drawO() throws InterruptedException {
		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 0).moveByOffset(0, 100)
				.moveByOffset(-50, 0).perform();
		Thread.sleep(5000);
	}

	@Ignore
	@Test
	public void drawN() throws InterruptedException {
		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 100).moveByOffset(0, -100)
				.perform();
		Thread.sleep(2000);
	}

	@Ignore
	@Test
	public void drawI() throws InterruptedException {
		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).perform();

		Thread.sleep(2000);
	}

	@Ignore
	@Test
	public void drawK() throws InterruptedException {
		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 50).moveByOffset(50, -50)
				.moveByOffset(0, 100).perform();
		Thread.sleep(2000);
	}

	@Ignore
	@Test
	public void drawA() throws InterruptedException {
		WebElement canvas = driver.findElement(By.id("catch"));
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -100).moveByOffset(50, 50).moveByOffset(50, -50)
				.moveByOffset(0, 100).perform();
		Thread.sleep(2000);

	}

	// @After
	// public static void finalise() {
	//
	// }

}
