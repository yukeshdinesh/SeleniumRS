package selenium4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipWindowAndTabs {
	WebDriver driver;

	//Multi window and tabs in sel 4
	@Test
	public void newTab() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
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
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(firstCourseString);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/");
		
	}
	
	@Test
	public void newWindow() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		
		String parentString = iterator.next();
		String childString = iterator.next();
		
		//driver.switchTo().window(childString);
		driver.get("https://rahulshettyacademy.com/");
		
		List<WebElement> courseList = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		for (WebElement webElement : courseList) {
			System.out.println(webElement.getText());
		}
		
		String firstCourseString = courseList.get(1).getText();
		System.out.println(firstCourseString);
		driver.close();
		
		driver.switchTo().window(parentString);
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(firstCourseString);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://rahulshettyacademy.com/");
		driver.close();
		
	}
}
