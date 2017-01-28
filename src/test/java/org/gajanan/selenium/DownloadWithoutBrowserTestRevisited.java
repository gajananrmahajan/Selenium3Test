package org.gajanan.selenium;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DownloadWithoutBrowserTestRevisited {
	WebDriver driver;
	String url = "http://the-internet.herokuapp.com/download";
			
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
	public void verifyDropDownList() throws Exception {
		String link = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getAttribute("href");
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		//HttpHead request = new HttpHead(link);
		HttpGet request = new HttpGet(link);
		System.out.println("Method being used: " + request.getMethod());
		HttpResponse response = httpClient.execute(request);
		System.out.println("Status code is " + response.getStatusLine().getStatusCode());
		
		String contentType = response.getFirstHeader("Content-Type").getValue();
		System.out.println("Content type is : " + contentType);
			
		int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
		System.out.println("Content length is : " + contentLength);
	}
}
