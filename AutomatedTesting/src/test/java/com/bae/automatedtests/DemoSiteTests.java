package com.bae.automatedtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSiteTests {

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
		driver.get("http://thedemosite.co.uk/");
	}

	@Ignore
	@Test
	public void selectAddUserLink() {
		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		assertEquals("http://thedemosite.co.uk/addauser.php", (addUser.getAttribute("href")));

	}

	@Ignore
	@Test
	public void selectUserField() {
		driver.navigate().to("http://thedemosite.co.uk/addauser.php");
		WebElement userField = driver.findElement(By.name("username"));
		userField.click();
		assertTrue(userField.isEnabled());
	}

	@Ignore
	@Test
	public void selectPasswordField() {
		driver.navigate().to("http://thedemosite.co.uk/addauser.php");
		WebElement pwField = driver.findElement(By.name("password"));
		pwField.click();
		assertTrue(pwField.isEnabled());
	}

	@Test
	public void addNewUser() {
		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		userField.click();
		userField.sendKeys("user");

		pwField.click();
		pwField.sendKeys("password");

		btn.click();
	}

	@Test
	public void newUserLogin() throws InterruptedException {

		driver.navigate().to("http://thedemosite.co.uk/addauser.php");
		WebElement login = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a"));
		login.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		userField.click();
		userField.sendKeys("user");

		pwField.click();
		pwField.sendKeys("password");

		btn.click();
		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));

		assertEquals("**Successful Login**", res.getText());

	}

}
