package com.finacus.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Appointment extends StoredXpath
{
	WebDriver d;
	ChromeOptions options;
	String appURL = "https://staging.travalab.com/appointments/new";
	String inputFilename = "./" + "src\\test\\java\\com\\finacus\\TestCase\\Appointment.xlsx";
	String sheetname = "Sheet1";
	JavascriptExecutor js = (JavascriptExecutor) d;

	@Test(dataProvider = "userdata")
	public void toLogin(String firstname, String lastname,String dob,String email,String phone ) throws InterruptedException 
	{
		
		String Address = null;
		String SelectLab = null;
		//String Lab4 = null;
		String Time = null;
		String AdditionalRequest = null;
		
	
		try
		{
			System.out.println("In Appointment Method");
			
			System.out.println("firstname is: " + firstname);
			System.out.println("lastname is: " + lastname);
			System.out.println("dob is: " + dob);
			System.out.println("email is: " + email);
			System.out.println("phone is: " + phone);
			System.out.println("Address is: " + Address);
			System.out.println("SelectLab is: " + SelectLab);
			System.out.println("Date is: " + Date);
			System.out.println("Time is: " + Time);
			System.out.println("AdditionalRequest is: " + AdditionalRequest);
			
		
			/*
			d.findElement(By.xpath("//label[@for='receivedKit']")).click();
			System.out.println("Click On YES Radio button");

			d.findElement(By.xpath("//input[@id='appointment_patient_first_name']")).sendKeys(firstname);
			System.out.println("Enter Firstname");
			d.findElement(By.xpath("//input[@id='appointment_patient_last_name']")).sendKeys(lastname);
			System.out.println("Enter Lastname");
			d.findElement(By.xpath("//input[@id='appointment_patient_birth_date']")).sendKeys(dob);
			System.out.println("Enter DOB");
			d.findElement(By.xpath("//input[@id='appointment_patient_email']")).sendKeys(email);
			System.out.println("Enter Email");
			d.findElement(By.xpath("//input[@id='appointment_patient_phone_number']")).sendKeys(phone);
			System.out.println("Enter Phone Number");
			d.findElement(By.xpath("//button[@class='btn btn-gradient nextBtn btn-lg pull-right w-100']")).click();
			System.out.println("Click on Next button");
			 */

		//	JavascriptExecutor js = (JavascriptExecutor) d;  
			//d.get("https://staging.travalab.com/appointments/new");
			System.out.println("User on Appointment Page");
			Thread.sleep(200);

			d.findElement(By.xpath(receivedKit)).click();
			System.out.println("Kit Received YES");
			Thread.sleep(200);

			d.findElement(By.xpath(FirstName)).sendKeys("Sushant");
			System.out.println("Enter First Name");

			d.findElement(By.xpath(LastName)).sendKeys("Kadam");
			System.out.println("Enter First Name");

			d.findElement(By.xpath(DOB)).sendKeys("18/01/1992");
			System.out.println("Enter DOB");

			d.findElement(By.xpath(Emailid)).sendKeys("sushant@gmail.com");
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

			Thread.sleep(2000);
		}
		
		catch (Exception e)
		{
			System.out.println("Failed");
		}
	}

	@BeforeClass 
	public void setup() 
	{
		System.out.println("In Setup method ____");
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
		System.out.println("In get data method ___");

		int rowcount = ExcelReadingMethods.getRowCount(inputFilename, sheetname);
		System.out.println("Rowcount is: " + rowcount);

		int cellcount = ExcelReadingMethods.getCellData(inputFilename, sheetname, 0);
		System.out.println("Cell count is: " + cellcount);

		String loginData[][] = new String[rowcount][cellcount];

		for (int row = 5; row <= rowcount; row++) 
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
		System.out.println("In tear down method ___");

		if (d != null)
		{
			d.close();
			d.quit();
		}
	}

}
