package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenerTest {
	
	WebDriver driver;
	EventFiringWebDriver eDriver;
	WebEventListener eventListener;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		eventListener = new WebEventListener();
		eDriver = new EventFiringWebDriver(driver);
		eDriver.register(eventListener);
		eDriver.manage().window().maximize();
		eDriver.get("http://the-internet.herokuapp.com/login");
	}
	
	@AfterClass
	public void tearDown(){
		eDriver.quit();
		
	}
	
	@Test
	public void verifyValidLogin() throws InterruptedException{
		//LoginPage login = new LoginPage(driver);
		eDriver.findElement(By.id("username")).sendKeys("tomsmith");
		eDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		eDriver.findElement(By.cssSelector("button")).click();
		
		Thread.sleep(3000);
	}
}
