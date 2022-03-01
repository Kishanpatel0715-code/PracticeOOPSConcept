package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By verifyMyAccountLink = By.xpath("(//div[@class='exehdJ'])[1]");


	public WebElement getVerifyMyAccountLink() {
		return getElement(verifyMyAccountLink);
	}

	public String getHomePageTitle() {
		return verifyPageTitle();
	}
	
	public boolean verifyMyaccountLink() {
		return getVerifyMyAccountLink().isDisplayed();
	}
	
}
