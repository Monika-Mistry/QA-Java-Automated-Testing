package com.bae.ddtpracticetests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import resources.Constants;

public class DemoSiteExcel {

	public static WebDriver driver;
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();

		try {
			file = new FileInputStream(Constants.PATH_TESTDATA + Constants.FILE_TESTDATA);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheetAt(0);

	}

	@AfterClass
	public static void teardown() {
		driver.quit();

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Before
	public void init() {
		driver.manage().window().maximize();
		driver.get(Constants.DSURL);
	}

	@Test
	public void readFromFile() {
		XSSFCell usr = sheet.getRow(0).getCell(0);
		XSSFCell pw = sheet.getRow(0).getCell(1);
		XSSFCell res = sheet.getRow(0).getCell(2);

		assertEquals("UserName", usr.getStringCellValue());
		assertEquals("Password", pw.getStringCellValue());
		assertEquals("Result", res.getStringCellValue());
	}

	@Test
	public void addUser1() {

		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		XSSFCell usr = sheet.getRow(1).getCell(0);
		XSSFCell pw = sheet.getRow(1).getCell(1);

		userField.click();
		userField.sendKeys(usr.getStringCellValue());

		pwField.click();
		pwField.sendKeys(pw.getStringCellValue());

		btn.click();

		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote"));

		assertTrue("UserName Not  As In TestData " + res.getText(), res.getText().contains("TestOne"));
		assertTrue("Password Not As In TestData " + res.getText(), res.getText().contains("PassOne"));

	}

	@Test
	public void addUser2() {

		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		XSSFCell usr = sheet.getRow(2).getCell(0);
		XSSFCell pw = sheet.getRow(2).getCell(1);

		userField.click();
		userField.sendKeys(usr.getStringCellValue());

		pwField.click();
		pwField.sendKeys(pw.getStringCellValue());

		btn.click();

		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote"));

		assertTrue("UserName Not  As In TestData " + res.getText(), res.getText().contains("TestTwo"));
		assertTrue("Password Not As In TestData " + res.getText(), res.getText().contains("PassTwo"));

	}

	@Test
	public void addUser3() {

		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		XSSFCell usr = sheet.getRow(3).getCell(0);
		XSSFCell pw = sheet.getRow(3).getCell(1);

		userField.click();
		userField.sendKeys(usr.getStringCellValue());

		pwField.click();
		pwField.sendKeys(pw.getStringCellValue());

		btn.click();

		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote"));

		assertTrue("UserName Not  As In TestData " + res.getText(), res.getText().contains("TestThree"));
		assertTrue("Password Not As In TestData " + res.getText(), res.getText().contains("PassThree"));

	}

	@Test
	public void addUser4() {

		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		WebElement userField = driver.findElement(By.name("username"));
		WebElement pwField = driver.findElement(By.name("password"));
		WebElement btn = driver.findElement(By.name("FormsButton2"));

		XSSFCell usr = sheet.getRow(4).getCell(0);
		XSSFCell pw = sheet.getRow(4).getCell(1);

		userField.click();
		userField.sendKeys(usr.getStringCellValue());

		pwField.click();
		pwField.sendKeys(pw.getStringCellValue());

		btn.click();

		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote"));

		assertTrue("UserName Not  As In TestData " + res.getText(), res.getText().contains("TestFour"));
		assertTrue("Password Not As In TestData " + res.getText(), res.getText().contains("PassFour"));

	}

	@Ignore
	@Test
	public void loginUsr1() {
		driver.navigate().to(Constants.ADDUSERURL);

		WebElement userFieldAU = driver.findElement(By.name("username"));
		WebElement pwFieldAU = driver.findElement(By.name("password"));
		WebElement btnAU = driver.findElement(By.name("FormsButton2"));

		XSSFCell usr = sheet.getRow(1).getCell(0);
		XSSFCell pw = sheet.getRow(1).getCell(1);
		XSSFCell rescell = sheet.getRow(1).createCell(2);

		userFieldAU.click();
		userFieldAU.sendKeys(usr.getStringCellValue());

		pwFieldAU.click();
		pwFieldAU.sendKeys(pw.getStringCellValue());

		btnAU.click();

		WebElement login = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));

		login.click();

		WebElement userField = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		WebElement pwField = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		WebElement btn = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));

		userField.sendKeys(usr.getStringCellValue());

		pwField.click();
		pwField.sendKeys(pw.getStringCellValue());

		btn.click();

		WebElement res = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));

		// System.out.println(rescell);

		// if (rescell.equals(null)) {
		// sheet.getRow(1).createCell(2);
		// }
		//
		// rescell.setCellValue(res.getText());

		try {
			FileOutputStream out = new FileOutputStream(new File(Constants.PATH_TESTDATA + Constants.FILE_TESTDATA));
			try {

				workbook.write(out);
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		assertTrue("Login First User Unsuccessful", res.getText().contains("Successful"));
	}

}
