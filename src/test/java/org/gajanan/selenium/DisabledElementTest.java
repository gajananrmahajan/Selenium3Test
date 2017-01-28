package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DisabledElementTest {

	private static final String url = "http://the-internet.herokuapp.com/dropdown";
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
	public void disabledElementTest() {
		//WebElement dropDowon = driver.findElement(By.id("dropdown"));
		/*List<WebElement> options = dropDowon.findElements(By.tagName("option "));
		
		for (WebElement option : options) {
			System.out.println(option.getText());
			Assert.assertFalse(options.get(0).isEnabled());
		}*/
		
		Select dropDown = new Select(driver.findElement(By.id("dropdown")));
		//Assert.assertFalse(dropDown.getOptions().get(0).isEnabled());
		assertThat(dropDown.getOptions().get(0).isEnabled(), is(false));
	}
}
