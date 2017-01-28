package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CSSTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/download";
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
		driver.quit();
	}
	
	@Test
	public void verifyCSS() {
		//System.out.println("First link is " + driver.findElement(By.cssSelector("a")).getAttribute("href"));
		
		//System.out.println("First link is " + driver.findElement(By.cssSelector(".example a")).getAttribute("href"));
		
		System.out.println("First link is " + driver.findElement(By.cssSelector(".example a")).getAttribute("href"));
		
	}
}
