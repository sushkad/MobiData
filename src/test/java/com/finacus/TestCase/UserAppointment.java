package com.finacus.TestCase;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserAppointment extends UAXpath 
{
	public static WebDriver d;
	JavascriptExecutor js = (JavascriptExecutor) d;

	@BeforeSuite
	public void setup() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver","D://Automation//chromedriver_win32//chromedriver.exe");
	   //d= new ChromeDriver();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver(chromeOptions);

		//d.manage().window().maximize();
		d.manage().deleteAllCookies(); 
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		d.get("https://staging.travalab.com/appointments/new");

		System.out.println("New Appointmant page"); 
		String url = "https://staging.travalab.com/appointments/new";
		//StringBuffer sb = new StringBuffer(url);
		//System.out.println(sb.reverse());
		//System.out.println(sb.length());
		Thread.sleep(100);
	}

	@Test (priority=1)	
	public void TC1Kit() throws InterruptedException, IOException
	{
		try
		{

			System.out.println("______________________________________________________________________________");

			d.findElement(By.xpath(kitNotRecieved)).click();
			System.out.println("Click on kitNotRecieved NO");

			d.findElement(By.xpath(nothavingRequisitionForm)).click();
			System.out.println("Select Option HavingRequisitionForm NO");

			d.findElement(By.xpath(MoreDetailspopup)).click();
			System.out.println("Click on OK button to confirm");

			Thread.sleep(2000);
		}

		catch(Exception e)
		{
			Thread.sleep(3000);
			System.out.println("Get the Screenshot");

			TakesScreenshot scrShot1 =((TakesScreenshot)d);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("D://WireFrame//Login.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
		}

	}
	/*
	@Test (priority = 2)
	public void TC2Covid19() throws InterruptedException
	{
		d.findElement(By.xpath(Covid19)).click();	
		d.findElement(By.id(Cfirstname)).sendKeys("Mayur");
		d.findElement(By.id(Clastname)).sendKeys("Shah");
		d.findElement(By.id(Cemail)).sendKeys("sushantdawaadda@gmail.com");
		d.findElement(By.id(Cphonenumber)).sendKeys("8652563323");
		d.findElement(By.id(Cresult)).click();
		d.findElement(By.id(Cresult)).sendKeys(Keys.ARROW_DOWN);

		d.findElement(By.xpath(CSend)).click();
		System.out.println("Click on Send button");
		Thread.sleep(3000);


	}
	 */

	@Test (priority=2)
	public void TC2Appointments() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) d;  
		d.get("https://staging.travalab.com/appointments/new");
		System.out.println("User on Appointment Page");
		Thread.sleep(200);

		d.findElement(By.xpath(receivedKit)).click();
		System.out.println("Kit Received YES");
		Thread.sleep(200);

		d.findElement(By.xpath(FirstName)).sendKeys("Rahul");
		System.out.println("Enter First Name");

		d.findElement(By.xpath(LastName)).sendKeys("Ayyapan");
		System.out.println("Enter First Name");

		d.findElement(By.xpath(DOB)).sendKeys("18/01/1991");
		System.out.println("Enter DOB");

		d.findElement(By.xpath(Emailid)).sendKeys("rahul@gmail.com");
		System.out.println("Enter Email ID");

		d.findElement(By.xpath(PhoneNumber)).sendKeys("8652522012");
		System.out.println("Enter PhoneNumber");


		//Thread.sleep(200);

		js.executeScript("arguments[0].scrollIntoView();", d.findElement(By.xpath(Next)));
		d.findElement(By.xpath(Next)).click();
		System.out.println("Click On Next Button");
		js.executeScript("arguments[0].scrollIntoView();", d.findElement(By.xpath(schAnApp)));
		//d.navigate().back();		
		Thread.sleep(200);


		d.findElement(By.id(Address)).sendKeys("3686 Grandview Pkwy");
		System.out.println("Enter Address");
		Thread.sleep(3000);
		d.findElement(By.id(Address)).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(300);
		d.findElement(By.id(Address)).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		d.findElement(By.xpath(AddressNext)).click();
		Thread.sleep(3000);
		System.out.println("Click on AddressNext button");

		Thread.sleep(300);

		d.findElement(By.xpath(SelectLab)).click();
		Thread.sleep(200);
		//d.findElement(By.xpath(SelectLab)).sendKeys(Keys.ARROW_DOWN);

		d.findElement(By.xpath(Lab4)).click();
		Thread.sleep(200);
		//d.findElement(By.xpath(SelectLab)).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		d.findElement(By.xpath(UNITY)).click();
		System.out.println("Click on Phlebotomy");
		Thread.sleep(300);

		d.findElement(By.xpath(LabNext)).click();
		Thread.sleep(100);


		String ExcelDate = "December 30, 2021";
		d.findElement(By.xpath("//span[@aria-label='"+ExcelDate+"' and (@tabindex)]")).click();
		System.out.println("Click on Date field");
		Thread.sleep(200);
		//d.findElement(By.xpath(Date31)).click();
		//Thread.sleep(200);
		d.findElement(By.xpath(Time)).click();
		Thread.sleep(200);
		d.findElement(By.xpath(Time1)).sendKeys("12");
		System.out.println("Enter Hours");
		Thread.sleep(200);
		d.findElement(By.xpath(AdditionalRequest)).sendKeys("Lab Name: BILLION TO ONE");
		System.out.println("Enter Lab Name");
		Thread.sleep(200);
		d.findElement(By.xpath(Nextbuttondateandtime)).click();
		System.out.println("Click on Next Date & Time");
		Thread.sleep(7000);

		System.out.println("Your appointment request was created successfully for Lab Name: BILLION TO ONE");
		Thread.sleep(200);
	}

	@Test (priority=3)
	public void TC3Login() throws InterruptedException, IOException
	{
		//d.get("https://staging.travalab.com/login");
		d.findElement(By.xpath(SignIN)).click();
		System.out.println("Click on Sign IN");

		d.findElement(By.xpath(Email)).sendKeys("support@travalab.com");
		System.out.println("Enter Email");

		d.findElement(By.xpath(password)).sendKeys("Travalab01");
		System.out.println("Enter Password");

		d.findElement(By.xpath(Login)).click();
		System.out.println("Click on Login");
		Thread.sleep(3000);

		d.findElement(By.xpath(Dateandtime)).click();
		Thread.sleep(200);
		d.findElement(By.xpath(Dateandtime)).click();
		Thread.sleep(2000);

		//d.findElement(By.xpath(AddAppointment)).click();
		//System.out.println("Next Appointment");
		//Thread.sleep(200);

		TakesScreenshot scrShot1 =((TakesScreenshot)d);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("D://WireFrame//BILLION TO ONE Appointment.png");
		FileUtils.copyFile(SrcFile1, DestFile1);
	}
	/*
	 * d.findElement(By.xpath(Search)).sendKeys("Sushant Lad"); Thread.sleep(200);
	 * System.out.println("Enter Client Name");
	 * 
	 * d.findElement(By.xpath(Search)).sendKeys(Keys.ENTER);
	 * System.out.println("Enter Name");
	 * 
	 * Thread.sleep(20000);
	 */

	/*
	@Test (priority=4)
	public void TC4Brokenlinks() throws InterruptedException
	{

		d.navigate().refresh(); 
		Thread.sleep(2000); 
		String homePage ="https://staging.travalab.com/admin/appointments"; 
		String url = "";
		HttpURLConnection huc = null; 
		int respCode = 200;

		List<WebElement> links = d.findElements(By.tagName("a"));
		System.out.println("Total links on the Web Page: " + links.size());

		Thread.sleep(300); 
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) 
		{ 
			url = it.next().getText(); 
			System.out.println(url); 
		}

		Thread.sleep(300); 
		while(it.hasNext()) 
		{
			url = it.next().getAttribute("href");
			System.out.println(url);

			if(url == null || url.isEmpty())
			{ 
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue; 
			}

			if(!url.startsWith(homePage))
			{
				System.out.println("URL belongs to another domain, skipping it."); 
				continue;
			}

			Thread.sleep(300);
			try 
			{ 
				huc = (HttpURLConnection)
						(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400)
				{ 
					System.out.println(url+" is a broken link"); 
				} else 
				{
					System.out.println(url+" is a valid link"); }
			} 
			catch (MalformedURLException e) 
			{ 
				e.printStackTrace(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
		} 

		Thread.sleep(300);
	}
*/

	/*
	 * @Test(priority=6) public void TC6() throws InterruptedException {
	 * 
	 * d.findElement(By.xpath(CC)).sendKeys("4242 4242 4242 4242");
	 * System.out.println("Enter CC"); Thread.sleep(200);
	 * d.findElement(By.xpath(Expmy)).sendKeys("03 / 24");
	 * System.out.println("Enter Expmy"); Thread.sleep(200);
	 * d.findElement(By.xpath(CVC)).sendKeys("145");
	 * System.out.println("Enter CVC"); Thread.sleep(200);
	 * d.findElement(By.xpath(Paynow)).click(); System.out.println("Pay Now");
	 * //d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 * Thread.sleep(7000);
	 * 
	 * }
	 */

	@Test (priority=5)
	public void TC5AppStatus() throws InterruptedException, IOException
	{
		Thread.sleep(300);	
		d.findElement(By.xpath(AppStatus)).click();
		System.out.println("Click on App Status");
		d.findElement(By.xpath(Completed)).click();
		System.out.println("Click on Completed Status");
		Thread.sleep(300);	
		d.findElement(By.xpath(Edit1)).click();
		Thread.sleep(300);
		d.findElement(By.xpath(Canceledit1)).click();
		System.out.println("Click ");
		Thread.sleep(300);
	}

	@AfterSuite
	public void CloseApp()
	{
		d.quit();
		//d.close();
		System.out.println("Application Close");		
	}
}
