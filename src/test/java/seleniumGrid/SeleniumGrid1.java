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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGrid1 {
	
	WebDriver driver;
	
//	@BeforeTest
//    static void setupClass() {
//		//WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
//		WebDriverManager.operadriver().setup();
//    }
	
	@Test(groups = {"Sanity","Smoke","Regression"})
	public void test1() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		driver.get("https://rahulshettyacademy.com/#/index");
		String title = driver.getTitle();
		System.out.println(title);	
		driver.close();
	}
	

}
