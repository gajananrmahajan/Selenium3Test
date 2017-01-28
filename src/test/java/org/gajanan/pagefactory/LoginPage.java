package org.gajanan.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/*By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginButtonLocator = By.cssSelector("button");*/
	
	@FindBy(how=How.ID, using="username")
	WebElement usernameLocator;
	
	@FindBy(how=How.ID, using="password")
	WebElement passwordLocator;
	
	@FindBy(how=How.CSS, using="button")
	WebElement loginButtonLocator;
	
	public void with(String username, String password){
		usernameLocator.sendKeys(username);
		passwordLocator.sendKeys(password);
		loginButtonLocator.click();
	}
	
}
