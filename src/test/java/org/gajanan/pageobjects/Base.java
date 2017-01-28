package org.gajanan.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {

	private WebDriver driver;
	private WebDriverWait wait;

	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	@BeforeMethod
	public void setUp(){
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
		driver = new FirefoxDriver();*/
		System.out.println("In before method: ");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("In after method: ");
		driver.quit();
	}
	
	public void visit(String url){
		driver.get(url);
	}
	
	public WebElement find(By locator){
		return driver.findElement(locator);
	}
	
	public void type(By locator, String textToType){
		find(locator).sendKeys(textToType);
	}
	
	public void click(By locator){
		find(locator).click();
	}
	
	public Boolean isDisplayed(By locator){
		try{
			return find(locator).isDisplayed();
		} catch(NoSuchElementException e){
			return false;
		}
		
	}
	
	public Boolean isDisplayed(By locator, Integer maxTime) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxTime);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut){
		timeOut = timeOut!=null ? timeOut : 5;
		wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}
}
