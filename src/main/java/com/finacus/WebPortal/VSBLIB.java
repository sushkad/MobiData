package com.finacus.WebPortal;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class VSBLIB extends VSBLIBXpath
{

	public static WebDriver d;
	JavascriptExecutor js = (JavascriptExecutor) d;
	//ExtentReports report;
	//ExtentTest logger;

	@BeforeSuite
	public void setup() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver","E://FIN_MobiConnect//chromedriver_win32_94//chromedriver.exe");
		d= new ChromeDriver();

		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("window-size=1400,800");
		//options.addArguments("headless");
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.get("http://192.168.4.105/Vsblinet/");
		System.out.println("You are VSBL IB page");
		//String title = d.getTitle();
		//Assert.assertTrue(title.contains("Vishweshwar Internet Banking"));

	}

	//@DataProvider
	//public void GetLogindata()
	//{	}

	@Test (priority=1)
	public void TC1Login() throws InterruptedException, IOException
	{
		try
		{
			System.out.println("___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___ ___");
			d.findElement(By.xpath(NewUserRegistration)).click();
			System.out.println("New User Registration?");

			//d.findElement(By.xpath(CustomerNumber)).sendKeys("72953576");
			Thread.sleep(200);
			//d.findElement(By.xpath(CustomerMobNo)).sendKeys("9892978931");
			d.findElement(By.xpath(Validatebutton)).click();
			System.out.println("Click on Validate button");
			d.switchTo().alert().accept();

			Thread.sleep(200);
			//Thread.sleep(3000);
			d.findElement(By.xpath(Backbutton)).click();
			System.out.println("Navigate on Login Page");

			// ==================================================================================

			Thread.sleep(200);
			d.findElement(By.xpath(ForgotUserId)).click();
			//d.findElement(By.id(accNo)).sendKeys("158652522019");
			//d.findElement(By.id(mobNo)).sendKeys("9892978931");
			//d.findElement(By.xpath(Continue)).click();
			//System.out.println("Click on Continue button");
			Thread.sleep(200);
			d.findElement(By.xpath(ForgotUserIdBack)).click();
			System.out.println("Click on Back button");

			// ==================================================================================

			Thread.sleep(200);

			d.findElement(By.xpath(ForgotPassword)).click();
			//d.findElement(By.xpath(ForgotuserId)).sendKeys("72953576");
			//d.findElement(By.xpath(ForgotmobNo)).sendKeys("9892978931");
			Thread.sleep(200);
			//d.findElement(By.xpath(GetOTP)).click();
			//d.switchTo().alert().accept();
			d.findElement(By.xpath(Forgotback)).click();

			System.out.println("Click on Back button From Forgot User ID");

			// ==================================================================================
			Thread.sleep(100);
			d.findElement(By.id(Email)).sendKeys("303310");
			System.out.println("Enter EmailID");
			Thread.sleep(2000);
			d.findElement(By.id(Password)).sendKeys("sachin$123");
			Thread.sleep(3000);

			/*
			File Src=d.findElement(By.id("captchaCode")).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"screenshots/captcha.png";
			FileHandler.copy(Src, new File(path));
			ITesseract image = new Tesseract();
			String imageText = image.doOCR(new File(path)); 

			String finalText = imageText.split("below")[1].replaceAll("[^a-zA-Z]","");
			System.out.println("Final Captcha is "+finalText);
			d.findElement(By.xpath(Captcha)).sendKeys(finalText);
			 */
			//System.out.println(imageText);

			System.out.println("Enter captchaCode");
			Thread.sleep(5000);
			d.findElement(By.xpath(Login)).click();

			System.out.println("Click on Login Button");
			Thread.sleep(50000);

		}
		catch (Exception e)
		{

			System.out.println("TC Failed");
		}
	}

	@Test (priority=2)
	public void TC2() throws InterruptedException, IOException
	{
		//WebDriverWait wait = new WebDriverWait(d,20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DEPOSIT)));
		//Thread.sleep(2000);

		//WebElement ele = d.findElement(By.xpath(DEPOSIT));
		//JavascriptExecutor jse = (JavascriptExecutor)d;
		//jse.executeScript("arguments[0].click()", ele);
		//Assert.assertTrue(ExpectedConditions.titleContains(DEPOSIT).apply(d).booleanValue());

		System.out.println("User is on Dashboard");
		d.findElement(By.xpath(DEPOSIT)).click();
		System.out.println("Click On DEPOSIT ACCOUNT");
		Thread.sleep(200);
		d.findElement(By.xpath(LOAN)).click();
		System.out.println("Click On LOAN ACCOUNT");
		Thread.sleep(200);

		d.findElement(By.xpath(CASA)).click();
		System.out.println("Click On CASA ACCOUNT");
		Thread.sleep(200);

		d.findElement(By.xpath(ViewAccount)).click();
		System.out.println("Click On ViewAccount button");
		Thread.sleep(20000);

		d.findElement(By.xpath(SelectAccount)).click();
		d.findElement(By.xpath(SelectAccount)).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Select Account From the List");

		Thread.sleep(200);
	}

	@Test (priority=3)
	public void TC3() throws InterruptedException, IOException
	{
		String parentWindow;
		parentWindow = d.getWindowHandle();
		d.switchTo().window(parentWindow);

		Thread.sleep(300);
		d.findElement(By.xpath(AccountSummary)).click();
		System.out.println("Click on AccountSummary menu");
		Thread.sleep(300);

	}
	
	@Test (priority=4)
	public void TC4() throws InterruptedException, IOException
	{		
		d.findElement(By.xpath(Help)).click();
		Thread.sleep(300);
		System.out.println("Click on Help Menu");

		String homePage = "http://192.168.4.105/Vsblinet/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = d.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext())
		{
			url = it.next().getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(homePage))
			{
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try 
			{
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		d.findElement(By.xpath(Logoutbutton)).click();
		Thread.sleep(300);
		System.out.println("Click on Logout button");
		//d.get("http://192.168.4.105/Vsblinet/");
		System.out.println("User navigate on Login page");
		
	}
	 
	@AfterSuite
	public void CloseApp()
	{
		d.close();
		System.out.println("Application Close");
	}
}
