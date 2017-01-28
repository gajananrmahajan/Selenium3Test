package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RightClickTest {

	private static final String url = "http://swisnl.github.io/jQuery-contextMenu/demo.html"; 
	//"http://the-internet.herokuapp.com/context_menu";
	WebDriver driver;
	

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void contextClickTest() {
		
		Actions action = new Actions(driver);
		//WebElement ele = driver.findElement(By.id("hot-spot"));
		WebElement ele = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));

		action.contextClick(ele).build().perform();
		action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
		action.click();
	}
}
