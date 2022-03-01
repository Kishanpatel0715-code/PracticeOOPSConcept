package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,30);
	}
	
	public abstract String verifyPageTitle();
	
	public abstract String verifyPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitforelementPresent(By locator);
	
	public abstract void waitforPageTitle(String title);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
