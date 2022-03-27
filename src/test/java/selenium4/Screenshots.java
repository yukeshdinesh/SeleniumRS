package selenium4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {
	
	WebDriver driver;
	
	@Test
	public void newScreenshot() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		  
		String parentString = iterator.next();
		String childString = iterator.next();
		
		driver.switchTo().window(childString);
		driver.get("https://rahulshettyacademy.com/");
		
		List<WebElement> courseList = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		for (WebElement webElement : courseList) {
			System.out.println(webElement.getText());
		}
		
		String firstCourseString = courseList.get(1).getText();
		System.out.println(firstCourseString);
		
		driver.switchTo().window(parentString);
		
		WebElement namElement = driver.findElement(By.cssSelector("input[name='name']"));
		namElement.sendKeys(firstCourseString);
		File srcFile = namElement.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get height and width of the element
		int height = namElement.getRect().getDimension().getHeight();
		int width = namElement.getRect().getDimension().getWidth();
		System.out.println(height);
		System.out.println(width);
		
		//get color
		String cssValue = namElement.getCssValue("color");
		String colorValueString = Color.fromString(cssValue).asHex();
		System.out.println(cssValue);
		System.out.println(colorValueString);

		
		
		
	}

}
