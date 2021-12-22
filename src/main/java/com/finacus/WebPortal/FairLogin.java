package com.finacus.WebPortal;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FairLogin extends FairQAXpath  {

	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		//desiredCapabilities.setCapability("appium:deviceName", "Galaxy Note9");
		//desiredCapabilities.setCapability("appium:platformVersion", "10");
		desiredCapabilities.setCapability("appium:deviceName", "V2025");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:appPackage", "com.bankwithfair.fairpayandroid.qa");
		desiredCapabilities.setCapability("appium:appActivity", "com.bankwithfair.fairpayandroid.ui.SplashActivity ");
		desiredCapabilities.setCapability("appium:ignoreHiddenApiPolicyError", "true");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		Thread.sleep(200);
	}
	
	// iphone 10 = 14.6
	// iphone 5S = 12.5
	// iphone 7 = 14.6

	@Test
	public void sampleTest() throws InterruptedException 
	{
		try
		{

			Thread.sleep(200);
			MobileElement el1 = (MobileElement) driver.findElementById(Notifiy1);
			el1.click();
			System.out.println("Tap On Notiification 1");
			Thread.sleep(100);
			MobileElement el2 = (MobileElement) driver.findElementById(Notifiy2);
			el2.click();
			System.out.println("Tap On Notiification 2");
			Thread.sleep(500);

			//driver.navigate().forward();
			//System.out.println("Navigate");


			//driver.get("com.bankwithfair.fairpayandroid.qa:id/action_bar_root");
			//System.out.println("Home Screen");

			MobileElement el3 = (MobileElement) driver.findElementById(Username);
			el3.click();
			System.out.println("Tap on UserName");
			MobileElement el4 = (MobileElement) driver.findElementById(Username);
			el4.sendKeys("FairPayTest05");
			System.out.println("Enter UserName");

			MobileElement el5 = (MobileElement) driver.findElementById(Password);
			el5.click();
			System.out.println("Tap on Password");
			MobileElement el6 = (MobileElement) driver.findElementById(Password);
			el6.sendKeys("Sushant@123");
			System.out.println("Enter Password");

			//MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup");
			//el7.click();
			//MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup");
			//el8.click();
			Thread.sleep(200);
			MobileElement el9 = (MobileElement) driver.findElementById(Login);
			el9.click();
			System.out.println("Click on Submit Button");

			Thread.sleep(200);
			MobileElement el10 = (MobileElement) driver.findElementById("com.bankwithfair.fairpayandroid.qa:id/textForgotPassword");
			el10.click();
			System.out.println("Tap On Forgot Password Link");
			MobileElement el11 = (MobileElement) driver.findElementById("com.bankwithfair.fairpayandroid.qa:id/txtLabelVisitWebsite");
			el11.click();
			System.out.println("Tap On Label");
		}

		catch (Exception e)
		{
			e.toString();
			System.out.println("Failed TC");
			
		}

	}

	@After
	public void tearDown() {
		driver.quit();
		//driver.close();
	}
}