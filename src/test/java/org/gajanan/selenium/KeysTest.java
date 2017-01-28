package org.gajanan.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeysTest {
	WebDriver driver;
	//String url = "http://the-internet.herokuapp.com/key_presses";
	String url = "https://github.com/SeleniumHQ/selenium/wiki/Advanced-User-Interactions?utm_medium=email&utm_campaign=elemental-selenium-java&utm_source=61-keyboard-keys&__s=3sr9emwkgzkmjz71ypfu";
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
	public void verifyKeys() throws InterruptedException, AWTException {
		Actions builder = new Actions(driver);
		//builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		//builder.keyDown(Keys.DOWN).build().perform();
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.id("id")));*/
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		
		Thread.sleep(5000);
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		Thread.sleep(5000);;
		
	}
}
