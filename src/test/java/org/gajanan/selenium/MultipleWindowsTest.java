package org.gajanan.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleWindowsTest {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/windows";
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
	public void verifyMultipleWindows() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "Opening a new window");
		
		String firstWindowHandle = driver.getWindowHandle();
		String newWindowHandle = "";
		
		driver.findElement(By.cssSelector(".example>a")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String windowHandle : windowHandles) {
			if(!firstWindowHandle.equals(windowHandle)){
				/*driver.switchTo().window(windowHandle);
				break;*/
				newWindowHandle = windowHandle;
			}
		}
		
		//Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "New Window");
		
		Thread.sleep(3000);
		driver.switchTo().window(firstWindowHandle);
		Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "Opening a new window");
		
		Thread.sleep(3000);
		driver.switchTo().window(newWindowHandle);
		Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "New Window");
		
		/*Object[] windowHandles = driver.getWindowHandles().toArray();
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		driver.switchTo().window(windowHandles[1].toString());		
		Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "New Window");
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, "w");
		driver.switchTo().window(windowHandles[0].toString());
		Assert.assertEquals(driver.findElement(By.cssSelector(".example>h3")).getText(), "Opening a new window");*/
	}
}
