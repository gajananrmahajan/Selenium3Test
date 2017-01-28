package org.gajanan.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFeatureTest {
	
	private WebDriver driver;
	private String baseUrl = "http://the-internet.herokuapp.com/login";
	
	@BeforeClass
	public void setUp(){
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
		driver = new FirefoxDriver();*/
		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);*/
		System.out.println("In before class: ");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("In after method: ");
		//driver.quit();
	}
	
	@Test
	public void verifyValidLogin() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		/*driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash"))));
		Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));*/ 
		
		Login login = new Login(driver);
		login.with(username, password);
		Assert.assertTrue(login.successMessagePresent());
	}
}
