package org.selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxLaunch {
  @Test
  public void f() {
	  //System.setProperty("webdriver.gecko.driver", "C:\\Users\\GAMAHAJA\\Desktop\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	  //System.setProperty("webdriver.firefox.marionette", "C:\\Users\\GAMAHAJA\\Desktop\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://www.google.com");
	  driver.close();
  }
}
