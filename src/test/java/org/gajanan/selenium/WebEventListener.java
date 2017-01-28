package org.gajanan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebEventListener extends AbstractWebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Opening " + url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Opened " + url);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding element " + by);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element " + by);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicking element " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked element " + element.toString());
	}
}
