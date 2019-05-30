package com.bae.automatedtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PHPTravelTest {

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
		driver.get("https://www.phptravels.net/");
	}

	@Ignore
	@Test
	public void searchHome() {
		WebElement in = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		WebElement out = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		WebElement search = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));

		in.sendKeys("30/05/2019");
		out.sendKeys("01/06/2019");
		search.click();

		String url = "https://www.phptravels.net/hotels/search/30-05-2019/01-06-2019/2/0";

		assertEquals(url, driver.getCurrentUrl());
	}

	@Ignore
	@Test
	public void goToPage2() {

		Actions action = new Actions(driver);
		WebElement in = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		WebElement out = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));

		in.sendKeys("30/05/2019");
		out.sendKeys("01/06/2019");
		searchBtn.click();

		WebElement p1 = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[2]"));
		action.moveToElement(p1).click().perform();
		System.out.println(driver.getCurrentUrl());

		WebElement p2 = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[3]"));
		action.moveToElement(p2).click().perform();

		System.out.println(driver.getCurrentUrl());

		WebElement plaza = driver.findElement(By.xpath(
				"//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[3]/td/div[2]/div/h4/a/b"));

		action.moveToElement(plaza).click().perform();

		String url = "https://www.phptravels.net/hotels/detail/London/Grand-Plaza-Apartments";
		System.out.println(driver.getCurrentUrl());

		assertEquals(url, driver.getCurrentUrl());

	}

	@Test
	public void submitBooking() {
		Actions action = new Actions(driver);
		driver.navigate().to("https://www.phptravels.net/hotels/detail/London/Grand-Plaza-Apartments");
		WebElement in = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		WebElement out = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		WebElement ppl = driver.findElement(By.xpath("//*[@id=\"adults\"]"));
		WebElement btn = driver
				.findElement(By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[5]/input[3]"));

		action.sendKeys(Keys.PAGE_DOWN).moveToElement(in).sendKeys("30/05/2019").perform();
		action.moveToElement(out).sendKeys("01/06/2019").perform();
		// out.sendKeys(Keys.TAB);
		action.moveToElement(ppl).sendKeys("3").perform();
		;
		action.moveToElement(btn).click().perform();

		WebElement room = driver.findElement(
				By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div"));

		action.sendKeys(Keys.PAGE_DOWN).moveToElement(room).click().perform();

		assertTrue(room.isSelected());
	}

}
