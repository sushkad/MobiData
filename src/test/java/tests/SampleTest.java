package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest extends AgentTestXpath {

	private AndroidDriver d;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:deviceName", "V2025");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:platformVersion", "11");
		desiredCapabilities.setCapability("appium:appPackage", "com.dev.tundra");
		desiredCapabilities.setCapability("appium:appActivity", "com.dev.tundra.MainActivity");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		d = new AndroidDriver(remoteUrl, desiredCapabilities);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Setup Completed");
	}

	@Test
	public void Logintest() throws InterruptedException, IOException
	{

		try
		{
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.findElement(By.xpath(Emailid)).sendKeys("sushantdawaadda@gmail.com");
			System.out.println("Enter Email id");

			d.findElement(By.xpath(Password)).sendKeys("India@2021");
			System.out.println("Enter Password");
			
			d.findElement(By.xpath(Login)).click();
			System.out.println("Click on Login Button");
		}
		catch(Exception e)
		{
			//Thread.sleep(400);
			System.out.println("Get the Screenshot");

			TakesScreenshot scrShot1 =((TakesScreenshot)d);
			File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
			File DestFile1=new File("E://FIN_MobiConnect//screenshots//travalaberror1.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
		}
	}

	@After
	public void tearDown() 
	{
		d.quit();
		//driver.quit();
	}
}

