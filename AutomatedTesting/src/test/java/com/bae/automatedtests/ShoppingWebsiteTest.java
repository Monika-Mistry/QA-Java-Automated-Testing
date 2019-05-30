package com.bae.automatedtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	public void searchBar() {
		WebElement searchBar = driver.findElement(By.name("search_query"));

		searchBar.click();
		assertTrue(searchBar.isEnabled());
	}

	@Test
	public void search() {
		WebElement searchBar = driver.findElement(By.name("search_query"));

		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);

		WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]"));

		assertEquals("\"dress\"", result.getText().toLowerCase());

	}

	@Test
	public void findItem() {

		WebElement searchBar = driver.findElement(By.name("search_query"));

		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		WebElement item = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));

		assertTrue(item.getText().contains("Printed Summer Dress"));
	}

	@Test
	public void selectItem() {

		WebElement searchBar = driver.findElement(By.name("search_query"));

		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		WebElement select = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		select.click();
		WebElement header = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
		assertTrue(header.getText().contains("Printed Summer Dress"));
	}

	@Test
	public void addItemToCart() {

		WebElement searchBar = driver.findElement(By.name("search_query"));

		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		WebElement select = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		select.click();

		WebElement addCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
		addCart.click();
	}
}
