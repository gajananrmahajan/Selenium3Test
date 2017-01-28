package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropTest {

	private static final String url = "http://jqueryui.com/droppable/"; 
	//"http://the-internet.herokuapp.com/context_menu";
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
	public void dragAndDropTest() throws InterruptedException {
		Actions action = new Actions(driver);
		
		//Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		/*action.dragAndDrop(driver.findElement(By.id("draggable")), 
				driver.findElement(By.id("droppable"))).build().perform();*/
		
		action.clickAndHold(driver.findElement(By.id("draggable")))
			.moveToElement(driver.findElement(By.id("droppable")))
			.release(driver.findElement(By.id("droppable"))).build().perform();
		
		Thread.sleep(3000);
		
	}
}
