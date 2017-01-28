package org.gajanan.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxTest {

	private static final String url = "http://the-internet.herokuapp.com/checkboxes"; 
	//"http://the-internet.herokuapp.com/context_menu";
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
	public void dragAndDropTest() throws InterruptedException {
		//driver.findElement(By.id("#checkboxes input:nth-of-type(1)")).isSelected();
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(2)")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(1)")).isSelected());
		
		driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(1)")).click();
		
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes > input:nth-of-type(1)")).isSelected());
	}
}
