package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTC {

	public static WebDriver d;
	JavascriptExecutor js = (JavascriptExecutor) d;
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E://FIN_MobiConnect//chromedriver_win32_94//chromedriver.exe");
		d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//d.get("http://192.168.4.46/videokyc/");
		d.get("http://192.168.4.105/Vsblinet/");
		System.out.println("You are IB page");
		Thread.sleep(300);

		
	}

}
