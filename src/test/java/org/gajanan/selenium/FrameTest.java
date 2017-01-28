package org.gajanan.selenium;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/tinymce";
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
	public void verifyFrames() throws InterruptedException{
		driver.switchTo().frame("mce_0_ifr");
		//driver.findElement(By.cssSelector("iframe[id='mce_0_ifr']"));
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Hello Frame!!!");
		
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Hello Frame!!!");
		
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector(".example>h3"));
	}
}
