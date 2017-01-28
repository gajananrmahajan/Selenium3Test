package org.gajanan.selenium;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DownloadTest {
 
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/download";
	File folder;
	String fileSeparator = System.getProperty("file.separator");
	String downloadDir;
	File[] listOfFiles;
	
	@BeforeClass
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//downloadDir =System.getProperty("user.dir") + fileSeparator + "src"+ fileSeparator+"test" + fileSeparator+"resources"+fileSeparator+folder;
		
		downloadDir =System.getProperty("user.dir") + fileSeparator + folder;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", downloadDir);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg, application/pdf, application/octet-stream");
		
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")
						+ fileSeparator + "src"+ fileSeparator+"test" + fileSeparator+"resources"+fileSeparator+"geckodriver.exe");
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.get(url);

		// ((ChromeDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		for (File file : listOfFiles) {
			file.delete();
		}
		
		folder.delete();
	}
  
  @Test
  public void downloadTest() throws Exception {
	  List<WebElement> links = driver.findElements(By.cssSelector(".example a"));
	  
	  for (WebElement link : links) {
		link.click();
		Thread.sleep(20000);
	}
	  
	  
	  listOfFiles = folder.listFiles();
	  
	  Assert.assertTrue(listOfFiles.length > 0);
	  
	  for (File file : listOfFiles) {
		Assert.assertTrue(file.length() > 0);
	}
  }

}
