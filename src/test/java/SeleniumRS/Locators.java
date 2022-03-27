package SeleniumRS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	public static WebDriver driver;
	public Locators() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Yukesh");
		//driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"+Keys.ENTER);
		driver.findElement(By.name("inputPassword")).sendKeys("hello");
		driver.findElement(By.className("signInBtn")).click();
		String errorText = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorText);
	}

	@Test
	public void test2() {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Enter user details and get error and print
		driver.findElement(By.id("inputUsername")).sendKeys("Yukesh");
		//driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"+Keys.ENTER);
		driver.findElement(By.name("inputPassword")).sendKeys("hello");
		driver.findElement(By.className("signInBtn")).click();
		String errorText = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorText);
		
		//Forget password and get the password and print
		driver.findElement(By.linkText("Forgot your password?")).click();
		wait(2);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Yukesh");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@email.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9966335522");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String infoMsg = driver.findElement(By.className("infoMsg")).getText();
		System.out.println(infoMsg);
		String[] split = infoMsg.split("'");
//		for (String string : split) {
//			System.out.println(string);
//		}
		System.out.println(split[1]);
		
		//Navigate to login page
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		wait(2);
		//Login with css selector elements
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Yukesh");
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(split[1]);
		driver.findElement(By.id("chkboxOne")).click();
		
		//different ways to use regex
		//input[placeholder^='Pass']
		//input[placeholder$='word']
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
	}
	
	@Test
	public void test3() {
		
		String nameString = "Yukesh"; 
		
		//get password
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		

		//Enter user details and get error and print
		driver.findElement(By.id("inputUsername")).sendKeys(nameString);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		wait(2);
		String heading = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(heading, "Hello "+nameString+",");
		
		String text = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(text, "You are successfully logged in.");
		System.out.println(text);
		
		//Logout
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		
	}
	
	public static String getPassword(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		wait(2);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Yukesh");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@email.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9966335522");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String infoMsg = driver.findElement(By.className("infoMsg")).getText();
		System.out.println(infoMsg);
		String[] split = infoMsg.split("'");
		for (String string : split) {
			System.out.println(string);
		}
		System.out.println(split[1]);
		
		return split[1];
		
	}
	
	public static void wait(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
