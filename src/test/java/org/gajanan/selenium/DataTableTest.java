package org.gajanan.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataTableTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/tables";
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
	public void verifyDataTable() throws InterruptedException {
		driver.findElement(By.cssSelector("#table1 > thead > tr th:nth-of-type(4) span")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> dues = driver.findElements(By.cssSelector("#table1 > tbody  tr td:nth-of-type(4)"));
		
		List<Double> actualDues = new ArrayList<Double>();
		
		for (WebElement due : dues) {
			actualDues.add(Double.parseDouble(due.getText().replace("$", "")));
		}
		
		System.out.println("Actual dues are :"  + actualDues);
		
		//Assert.assertEquals(actualDues, Arrays.asList("$50.00", "$50.00", "$51.00", "$100.00"));
		
		for (int counter = 0; counter < actualDues.size()-1; counter++) {
			Assert.assertTrue(actualDues.get(counter) <= actualDues.get(counter + 1), "Failed at " + counter);
		} 
	}
}
