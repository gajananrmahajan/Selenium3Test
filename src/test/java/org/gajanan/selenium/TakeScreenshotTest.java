package org.gajanan.selenium;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TakeScreenshotTest{
	WebDriver driver = null;
	String url = "http://the-internet.herokuapp.com/abtest";
	String fileSeparator = System.getProperty("file.separator");
	File folder;
	
	@BeforeClass
	public void setUp() {
		
		folder = new File("FailureScreenshots");
		folder.mkdir();
		
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
	public void verifyTakeScreenshot() throws Exception {
		driver.findElement(By.cssSelector(".example > h4"));
		//Assert.assertTrue(false, "Intentionally failed the test");
		
		/* File folder = new File("FailureScreenshots");
		 folder.mkdir();
		
		String heading = driver.findElement(By.cssSelector(".example > h3")).getText();
		
		heading = driver.findElement(By.cssSelector(".example > h3")).getText();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		File targetFile = new File(System.getProperty("user.dir") + fileSeparator + folder + fileSeparator + "verifyTakeScreenshotFailure.png");
		//FileUtils.copyFile(srcFile, new File("C:\\verifyTakeScreenshotFailure.png"));
		
		FileUtils.copyFile(srcFile, targetFile);
		//Assert.assertTrue(heading.startsWith("No A/B Test"));
*/	}
	
	@Test
	public void againFail(){
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void afterMethod(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
			File targetFile = new File(System.getProperty("user.dir") + fileSeparator + folder + fileSeparator + result.getMethod() + ".png");
			
			try {
				FileUtils.copyFile(srcFile, targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//t.println(result.getTestClass() +"." + result.getMethod() + " test failed, taking screenshot: ");
		 		
	}
}
