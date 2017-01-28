package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ABTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/abtest";
	String fileSeparator = System.getProperty("file.separator");
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ fileSeparator + "src"+ fileSeparator+"test" + fileSeparator+"resources"+fileSeparator+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void verifyDropDownList() throws InterruptedException {
		String heading = driver.findElement(By.cssSelector(".example > h3")).getText();
		Assert.assertTrue(heading.startsWith("A/B Test"));
		
		driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
		
		driver.navigate().refresh();
		
		heading = driver.findElement(By.cssSelector(".example > h3")).getText();
		Assert.assertTrue(heading.startsWith("No A/B Test"));
	}
}
