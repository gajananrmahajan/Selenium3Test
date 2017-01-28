package org.gajanan.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/dropdown";
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
	public void verifyDropDownList() throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("dropdown")));
		
		List<WebElement> options = select.getOptions();
		
		for (WebElement option : options) {
			System.out.println("Option is: " + option.getText());
		}
		select.selectByVisibleText("Option 1");
		
		
		Thread.sleep(3000);
		
		System.out.println("Selected option is: " + select.getFirstSelectedOption().getText());
		//select.deselectByValue("1");
		
		Thread.sleep(3000);
		
	}
}
