package org.gajanan.selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadTest {

	private static final String url = "http://the-internet.herokuapp.com/upload";
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		// ((ChromeDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyUpload() throws InterruptedException {
		driver.findElement(By.id("file-upload")).sendKeys(
				System.getProperty("user.dir") + "//src//test//resources//image001.jpg");
		driver.findElement(By.cssSelector(".button")).click();
		Assert.assertEquals(driver.findElement(By.id("uploaded-files"))
				.getText(), "image001.jpg");
		Thread.sleep(3000);
	}

	@Test
	public void randomTest() {
		// Random rn = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.println(new Random().nextInt(8) + 2);
		}

	}
}
