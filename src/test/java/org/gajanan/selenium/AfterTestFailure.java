package org.gajanan.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AfterTestFailure {
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
	public void scrollElementToView() throws InterruptedException {
		 driver.findElement(By.id("abc"));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{

		if(result.getStatus() == ITestResult.FAILURE){
			System.out.println("Test " + result.getMethod() + " has failed");
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File targetFile = new File(System.getProperty("user.dir") + fileSeparator + "FailureScreenshots" + fileSeparator + result.getMethod() + ".png");
			
			FileUtils.copyFile(srcFile, targetFile);
		}
	}
	
}
