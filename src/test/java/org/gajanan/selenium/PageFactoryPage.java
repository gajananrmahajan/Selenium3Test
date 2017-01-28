package org.gajanan.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageFactoryPage {

	@FindBy(id="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.ID, using="password")
	WebElement password;
}
