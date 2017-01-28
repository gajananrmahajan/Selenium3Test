package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionRevisitedTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/notification_message_rendered";
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
		//driver.quit();
	}
	
	@Test
	public void verifyDropDownList() throws InterruptedException {
		String expectedMessage = "Action successful";
		//String actualMessage = null;
		driver.findElement(By.xpath("//a[text()='Click here']")).click();
		String successMessage = driver.findElement(By.id("flash")).getText();
		if(!successMessage.contains(expectedMessage)){
			/*actualMessage=*/retryIfMessageIsNotAsExpected(expectedMessage);
		}
		//Assert.assertEquals(actualMessage, expectedMessage);
		
	}
	
	public void retryIfMessageIsNotAsExpected(String expectedMessage){
		String message = null;
		
		for(int i=0; i < 3; i++){
			driver.findElement(By.xpath("//a[text()='Click here']")).click();
			message = driver.findElement(By.id("flash")).getText();
			if (message.contains(expectedMessage)) {
				break;
			}else if (i>=2) {
				Assert.fail("Unable to find success message");
			}
		}
	}
}
