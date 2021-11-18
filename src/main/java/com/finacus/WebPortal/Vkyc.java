package com.finacus.WebPortal;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Vkyc extends Vkycxpath
{

	public static WebDriver d;

	JavascriptExecutor js = (JavascriptExecutor) d;

	@BeforeSuite
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E://FIN_MobiConnect//chromedriver_win32_94//chromedriver.exe");

		d= new ChromeDriver();

		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("window-size=1400,800");
		//options.addArguments("headless");

		//d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//d.get("http://192.168.4.46/videokyc/");
		d.get("http://192.168.4.105/Vsblinet/");


		System.out.println("You are IB page");
		String url = "http://192.168.4.105/Vsblinet/";
		StringBuffer sb = new StringBuffer(url);
		System.out.println(sb.reverse());
		System.out.println(sb.length());
		Thread.sleep(300);

	}


	@Test (priority=1)
	public void TC1() throws InterruptedException, IOException
	{
		try
		{
			System.out.println("______________________________________________________________________________");
			d.findElement(By.xpath(VKYC)).click();
			System.out.println("Click on VKYC menu");
			Thread.sleep(300);
			d.findElement(By.xpath(Continue)).click();
			System.out.println("Click on Continue button");
			Thread.sleep(300);
			d.findElement(By.xpath(MobileNumber)).sendKeys("9137011410");
			System.out.println("Enter Mobile Number"); //MobileSubmit
			Thread.sleep(300);
			d.findElement(By.xpath(MobileSubmit)).click();
			System.out.println("Click On Submit button");
			Thread.sleep(300);
			d.findElement(By.xpath(MobileOK)).click();
			System.out.println("Click On OK button");
			Thread.sleep(10000);

			d.findElement(By.xpath(MobileOK)).click();
			System.out.println("Validate Mobile");
			Thread.sleep(300);

			d.findElement(By.xpath(TxtOTP)).sendKeys("");
			System.out.println("Enter OTP");
			Thread.sleep(300);
			d.findElement(By.xpath(OTPSubmit)).click();
			System.out.println("OTP Submit");
			Thread.sleep(300);
			d.findElement(By.xpath(OTPvalidate)).click();
			System.out.println("OTP Validate Successfully");
			Thread.sleep(300);
		}

		catch(Exception e)
		{
			Thread.sleep(400);
			System.out.println("Get the Screenshot");

			TakesScreenshot scrShot1 =((TakesScreenshot)d);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("E://FIN_MobiConnect//error.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
		}

	}

	@Test (priority=2)
	public void TC2() throws InterruptedException, IOException
	{

		try
		{
			//d.get("http://192.168.4.46/videokyc/CustomerInfo");

			d.findElement(By.id(Title)).click();
			System.out.println("Click on Title");
			d.findElement(By.xpath(TitleMr)).click();
			//d.findElement(By.xpath(Title)).sendKeys(Keys.ARROW_DOWN);
			System.out.println("Select Title");
			Thread.sleep(200);

			d.findElement(By.xpath(NameasAaddhar)).sendKeys("Sushant");
			System.out.println("Enter Name");
			Thread.sleep(200);

			d.findElement(By.xpath(DOB)).sendKeys("27/01/1990");
			System.out.println("Enter DOB");
			Thread.sleep(200);

			d.findElement(By.xpath(Gender)).click();
			d.findElement(By.xpath(Gendermale)).click();
			//d.findElement(By.xpath(Gender)).sendKeys(Keys.ARROW_DOWN);
			System.out.println("Select Gender");
			Thread.sleep(200);

			d.findElement(By.xpath(Status)).click();
			d.findElement(By.xpath(Statussingle)).click();
			//d.findElement(By.xpath(Status)).sendKeys(Keys.ARROW_DOWN);
			System.out.println("Select Status");
			Thread.sleep(200);

			d.findElement(By.xpath(Stateselect)).click();
			d.findElement(By.xpath(Stategujarat)).click();
			System.out.println("select state");
			Thread.sleep(200);

			d.findElement(By.xpath(Email)).sendKeys("virat@gmail.com");
			System.out.println("Enter Email ID");
			Thread.sleep(200);

			d.findElement(By.xpath(House)).sendKeys("Parel");
			System.out.println("Enter House");
			Thread.sleep(200);

			d.findElement(By.xpath(Locality)).sendKeys("Malad");
			System.out.println("Enter Locality");
			Thread.sleep(200);

			/*d.findElement(By.xpath(Stateselect)).click();
		//d.findElement(By.xpath(state)).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Select State");
		Thread.sleep(200);
			 */

			d.findElement(By.xpath(City)).click();
			//d.findElement(By.xpath(City)).sendKeys(Keys.ARROW_DOWN);
			System.out.println("Select City");
			Thread.sleep(200);

			d.findElement(By.xpath(District)).sendKeys("Satara");
			System.out.println("Enter District");
			Thread.sleep(200);

			d.findElement(By.xpath(Pincode)).sendKeys("415002");
			System.out.println("Enter Pincode");
			Thread.sleep(200);

			d.findElement(By.xpath(Landmark)).sendKeys("Near Par");
			System.out.println("Enter Landmark");
			Thread.sleep(200);


			d.findElement(By.xpath(NextButton)).click();
			System.out.println("Enter nextButton");

			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("----------------------------------------");
			Thread.sleep(4000);
			System.out.println("Get the Screenshot");

			TakesScreenshot scrShot1 =((TakesScreenshot)d);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("E://FIN_MobiConnect//KYC1.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
		}

	}

	
	
	@AfterSuite
	public void CloseApp()
	{
		d.close();
		System.out.println("Application Close");
	}
}
