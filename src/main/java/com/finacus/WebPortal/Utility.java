package com.finacus.WebPortal;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static WebDriver d;
	public static String captureScreenshot(WebDriver driver,String scname) 
	{

		//return scname;
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String dest = "E:\\FIN_MobiConnect\\screenshots\\VSBL"+scname+".png";

			File destination = new File(dest);

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot Taken");

			return dest;

		}
		catch (Exception e)
		{
			System.out.println("Exception While Taking Screenshot "+e.getMessage());
			return e.getMessage();
		}
	}

}
