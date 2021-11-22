package com.finacus.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.finacus.TestCase.ExcelReadingMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDemo 
{
	WebDriver d;
	ChromeOptions options;
	String appURL = "https://staging.travalab.com/login";
	String inputFilename = "./" + "src\\test\\java\\com\\finacus\\TestCase\\travalab.xlsx";
	String sheetname = "login";

	@Test(dataProvider = "userdata")
	public void toLogin(String username, String password) throws InterruptedException 
	{

		System.out.println("In Login Method");

		System.out.println("username is: " + username);
		System.out.println("password is: " + password);

		d.findElement(By.id("user_email")).sendKeys(username);
		System.out.println("Enter Username");
		d.findElement(By.id("user_password")).sendKeys(password);
		System.out.println("Enter Password");
		d.findElement(By.xpath("//input[@name='commit']")).click();
		System.out.println("Click on Login button");

		Thread.sleep(2000);
		//d.findElement(By.xpath("driver.findElement(By.xpath(\"//input[@name='commit']\")).click();")).click();
		//d.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

		Thread.sleep(2000);
	}
	
	/*
		System.out.println("Alert flag is: " + alertExist());

		if (alertExist() == true) {
			System.out.println("Alert is present!!!");
			driver.switchTo().alert().accept();
			Thread.sleep(4000);
			System.out.println("Alert is closed!!!");
			Assert.assertTrue(true);
		} else {
			System.out.println("In else");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			System.out.println("Alert is closed!!!!");
			Assert.assertTrue(true);
		}
	}

	public boolean alertExist() {
		boolean alertFlag = false;
		try {
			driver.switchTo().alert();
			alertFlag = true;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertFlag;
	}
	 */

	@BeforeClass 
	public void setup() 
	{
		System.out.println("In setup method");
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		d = new ChromeDriver(options);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.get(appURL);
		d.manage().window().maximize();
	}

	@DataProvider(name = "userdata")
	public String[][] getData() throws IOException 
	{
		System.out.println("In get data method");

		int rowcount = ExcelReadingMethods.getRowCount(inputFilename, sheetname);
		System.out.println("Rowcount is: " + rowcount);

		int cellcount = ExcelReadingMethods.getCellData(inputFilename, sheetname, 0);
		System.out.println("Cell count is: " + cellcount);

		String loginData[][] = new String[rowcount][cellcount];
		for (int row = 1; row <= rowcount; row++) 
		{
			for (int cell = 0; cell < cellcount; cell++)
			{
				loginData[row - 1][cell] = ExcelReadingMethods.getCellData(inputFilename, sheetname, row, cell);
			}
		}
		return loginData;
	}

	@AfterClass
	public void tearDown() 
	{
		System.out.println("In tear down method");
		if (d != null)
		{
			d.close();
			d.quit();
		}
	}

}
