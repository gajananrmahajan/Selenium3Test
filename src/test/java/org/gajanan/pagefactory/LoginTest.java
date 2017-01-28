package org.gajanan.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/login");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		
	}
	
	@Test
	public void verifyValidLogin(){
		//LoginPage login = new LoginPage(driver);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.with("tomsmith", "SuperSecretPassword!");
	}
}
