package org.gajanan.selenium;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadSecureFileTest {
	WebDriver driver;
	String url = "http://admin:admin@the-internet.herokuapp.com/download_secure";
	//String url = "http://the-internet.herokuapp.com/download";
	String baseUrl = "http://the-internet.herokuapp.com/";
			
			
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
		String link = driver.findElement(By.xpath("//a[text()='some-file.txt']")).getAttribute("href");
		
		org.openqa.selenium.Cookie cookie = driver.manage().getCookieNamed("rack.session");
		//String link1 = url + "/some-file.text";
		/*DefaultHttpClient client = new DefaultHttpClient();
		
		HttpGet getRequest = new HttpGet(link) ;
		HttpResponse response = client.execute(getRequest);
		System.out.println("Status code is: " + response.getStatusLine());
		
		HttpEntity entity = response.getEntity();
		System.out.println("Content type is " + entity.getContentType().getName());
		System.out.println("Content type is " + response.getHeaders("content_type"));
		System.out.println("Content length is " + response.getHeaders("content_length"));*/
	
		/*URL url = new URL(link);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		System.out.println("GET method: " + connection.getRequestMethod());
		System.out.println("GET response code: " + connection.getResponseCode());*/
		
		Client client = ClientBuilder.newClient();

		WebTarget resource = client.target(link);

		Invocation.Builder request = resource.request()/*.accept(MediaType.APPLICATION_JSON)*/;
		request.cookie(cookie.getName(), cookie.getValue());
		Response response = request.get(Response.class);
		System.out.println("Response is :" + response.getStatus());
		Assert.assertEquals(response.getStatus(), 200);
		System.out.println("Length is :" + response.getLength());
		
		System.out.println("Headers are: " + response.getHeaders());
	}
}
