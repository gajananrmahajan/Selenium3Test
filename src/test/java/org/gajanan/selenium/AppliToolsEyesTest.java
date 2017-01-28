package org.gajanan.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.applitools.eyes.Eyes;

public class AppliToolsEyesTest {
	
	private WebDriver driver;
	private Eyes eyes;
	private static final String url = "http://the-internet.herokuapp.com/context_menu";
	private WebDriverWait wait;
	
	@BeforeClass
	public void setUp(){
		//wait = new WebDriverWait(driver, 5);
		final String browser = System.getProperty("browser", "firefox");
		System.out.println("((((((((((((((((((((    " + System.setProperty("browser", "firefox")); 
		System.out.println("______________________      " + System.getProperty("browser"));
		wait.until(ExpectedConditions.alertIsPresent());
		eyes = new Eyes();
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eyes.checkWindow("Home");
		driver.get(url);
		eyes.checkWindow("Google");
		eyes.close();
	}

	@AfterClass
	public void tearDown(){
		eyes.abortIfNotClosed();
		driver.quit();
	}
	
	@Test
	public void test(){
		
	}
}
