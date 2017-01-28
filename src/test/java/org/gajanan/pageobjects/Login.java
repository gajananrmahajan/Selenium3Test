package org.gajanan.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Base{
	
	//private WebDriver driver;
	By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginButtonLocator = By.cssSelector("button");
	By successMessageLocator = By.cssSelector(".flash.success");
		
	public Login(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		visit("http://the-internet.herokuapp.com/login");
	}
	
	public void with(String username, String password){
		/*driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(loginButtonLocator).click();*/
		
		type(usernameLocator, username);
		type(passwordLocator, password);
		click(loginButtonLocator);
	}
	
	public Boolean successMessagePresent(){
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator)).isDisplayed();*/
		
		return isDisplayed(successMessageLocator);
	}
	
}
