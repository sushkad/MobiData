package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Agentapp extends AgentTestXpath{

	private static final String DECLINE = null;
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	private AndroidDriver d;

	@BeforeSuite
	public void setUp() throws MalformedURLException 
	{
		try
		{			
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "V2025");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		
			capabilities.setCapability("APP_PACKAGE","com.dev.tundra");
			capabilities.setCapability("APP_ACTIVITY","com.dev.tundra.MainActivity");
			
			d = new AndroidDriver<MobileElement>(url,capabilities);
			//d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//d.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("End Before Method");	
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}	

	}

	@Test (priority=1)
	public void LoginTC01() throws InterruptedException 
	{
		
		try
		{
	
		d.findElement(By.xpath(Emailid)).sendKeys("sushantdawaadda@gmail.com");
		System.out.println("Enter Email id");

		d.findElement(By.xpath(Password)).sendKeys("India@2021");
		System.out.println("Enter Password");
		
		d.findElement(By.xpath(Login)).click();
		System.out.println("Click on Login Button");
		
		}
		
		/*
		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]");
		el1.sendKeys("sushantdawaadda@gmail.com");
		System.out.println("Enter Email ID");
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
		el2.sendKeys("India@2021");
		System.out.println("Enter Password");
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("LOGIN");
		el3.click();
		System.out.println("Click on Login Button");
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("OK");
		el4.click();
		System.out.println("Click On OK Button");
		MobileElement el5 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		el5.click();
		System.out.println("Click On Allow Permission");
		Thread.sleep(200);
		*/
	
		catch(Exception e)
		{
			System.out.println("TC Failed");
		}
	}
/*
	@Test (priority=2)
	public void HomeTC02() throws InterruptedException
	{

		System.out.println("TC2");
	}

	@Test (priority=3)
	public void TabsTC03() throws InterruptedException
	{
		System.out.println("TC3");	
		Thread.sleep(200);
	}

	@Test (priority=4)
	public void TabsTC04() throws InterruptedException
	{
		System.out.println("TC4");	
		Thread.sleep(200);
	}
*/	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}