package org.gajanan.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptPopUpsTest {

	private static final String url = "http://the-internet.herokuapp.com/javascript_alerts"; 
	WebDriver driver;
	String fileSeparator = System.getProperty("file.separator");

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ fileSeparator + "src"+ fileSeparator+"test" + fileSeparator+"resources"+fileSeparator+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void javaScriptAlertTest() throws InterruptedException {
		driver.findElement(By.cssSelector(".example li:nth-of-type(1) button")).click();
		driver.switchTo().alert().accept();
		System.out.println("Message after alert accept: " + driver.findElement(By.cssSelector("#result")).getText());
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".example li:nth-of-type(1) button")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Message after alert accept: " + driver.findElement(By.cssSelector("#result")).getText());
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".example li:nth-of-type(2) button")).click();
		driver.switchTo().alert().accept();
		System.out.println("Message after alert accept: " + driver.findElement(By.cssSelector("#result")).getText());
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".example li:nth-of-type(1) button")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Message after alert accept: " + driver.findElement(By.cssSelector("#result")).getText());
		
		Thread.sleep(3000);
	}
}
