package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String verifyPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String verifyPageHeader(By locator) {
		return getElement(locator).toString();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element  = null;
		try {
			element = driver.findElement(locator);
			return element;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public void waitforelementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void waitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
