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

public class VisualLocatorVerificationTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/large";
	
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
	public void highlightElementTest() throws InterruptedException, AWTException {
		 WebElement element = driver.findElement(By.id("sibling-2.3"));
		
		Thread.sleep(3000);
		 highlightElement(element, 5);
		
	}
	
	private void highlightElement(WebElement element, int duration) throws InterruptedException{
		String originalStyle = element.getAttribute("style");
		System.out.println("Original style is " + originalStyle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,  "style",
                "border: 2px solid red; border-style: dashed;");
		
		if(duration > 0){
			Thread.sleep(duration * 1000);
			
			js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, originalStyle);
		}
		
		Thread.sleep(5000);
	}
}
