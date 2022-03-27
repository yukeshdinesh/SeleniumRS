package selenium4;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator {
	
	WebDriver driver;
	
	@Test
	public void RelativeLocators() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		
		//Find the webelement above
		WebElement namElement = driver.findElement(By.cssSelector("[name='name']"));
		String nameString  = driver.findElement(with(By.tagName("label")
				).above(namElement)
				).getText();
		System.out.println(nameString);
		
		//Below
		String emailString  = driver.findElement(with(By.tagName("div")
				).below(namElement)
				).getText();
		
		System.out.println(emailString);
		
		//Left
		WebElement icecream = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecream)).click();
		
		//Right
		WebElement radioElement = driver.findElement(By.id("inlineRadio1"));
		String radioString = driver.findElement(with(By.tagName("label")).toRightOf(radioElement)).getText();
		System.out.println(radioString);
		
		 
		
		
		
	}

}
