package seleniumGrid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGrid1 {
	
	public static WebDriver driver;
	
	@BeforeTest
    static void setupClass() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test(groups = {"Sanity","Smoke","Regression"})
	public void test1() throws MalformedURLException {
		
		driver.get("https://rahulshettyacademy.com/#/index");
		String title = driver.getTitle();
		System.out.println(title);	
		driver.close();
	}
	
	
	//A way to include the retry analyser in the test annotation itself
	
//	@Test(groups = {"Sanity","Smoke","Regression"}, retryAnalyzer = utils.RetryAnalyser.class)
//	public void failtest1() throws MalformedURLException {
//		
//		String title = driver.getTitle();
//		System.out.println(title);	
//		Assert.assertEquals(title, "");
//		driver.close();
//	}
//	
	@Test(groups = {"Sanity","Smoke","Regression"})
	public void failtest2() throws MalformedURLException {
		
		driver.get("https://rahulshettyacademy.com/#/index");
		String title = driver.getTitle();
		System.out.println(title);	
		Assert.assertEquals(title, "");
		driver.close();
	}

}
