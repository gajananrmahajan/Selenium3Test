package org.gajanan.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoversTest {

	private static final String url = "http://the-internet.herokuapp.com/hovers"; 
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
	public void hoversTest() throws InterruptedException {
		List<WebElement> users = driver.findElements(By.cssSelector(".example div[class='figure']"));
		
		Actions action = new Actions(driver);
		
		int i = 0;
		for (WebElement user : users) {
			i++;
			action.moveToElement(user).build().perform();
			//Thread.sleep(3000);
			Assert.assertEquals(user.findElement(By.cssSelector(".figcaption > h5")).getText(), "name: user" + i);
			Assert.assertEquals(user.findElement(By.cssSelector(".figcaption > a")).getAttribute("href"), "http://the-internet.herokuapp.com/users/" + i);
		}
	}
}
