package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//By locators
	private By LoginBtn  = By.xpath("//a[contains(text(),'Login')]");
	
	private By returnLink = By.linkText("Return Policy");
	
	private By HomeDropdownLink = By.xpath("(//div[@class='xtXmba'])[6]");
	
	private By searchBox = By.name("q");
	
	private By email = By.xpath("(//div[@class='IiD88i _351hSN']/input)[1]");
	
	private By password = By.xpath("(//div[@class='IiD88i _351hSN']/input)[2]");
	
	private By login = By.xpath("(//button[@class='_2KpZ6l _2HKlqd _3AWRsL'])[1]");

	public WebElement getLoginBtn() {
		return getElement(LoginBtn);
	}

	public WebElement getReturnLink() {
		return getElement(returnLink);
	}

	
	public WebElement getHomeDropdownLink() {
		return getElement(HomeDropdownLink);
	}

	public WebElement getSearchBox() {
		return getElement(searchBox);
	}

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLogin() {
		return getElement(login);
	}

	///methods-----------------------------------
	public String verifyLoginTitle() {
		return verifyPageTitle();
	}
	
	public void VerifyReturnLink() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",returnLink );
		
		getElement(returnLink).click();
	}
	
	public void VerifyHomeDropdownList() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(getHomeDropdownLink()).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> homeLinks = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		System.out.println(homeLinks.size());
		
		for(WebElement a:homeLinks) {
			System.out.println(a.getText());
		}
	}
	
	public void searchBoxItem() throws InterruptedException {
		String s1 = getSearchBox().getAttribute("placeholder");
		System.out.println(s1);
		Thread.sleep(2000);
		
		getSearchBox().sendKeys("iphone");
		String s2 = getSearchBox().getAttribute("value");
		System.out.println(s2);
	}
	
	public HomePage doLogin(String em,String pwd) throws InterruptedException{
		getLoginBtn().click();
		Thread.sleep(2000);
		
		getEmail().sendKeys(em);
		getPassword().sendKeys(pwd);
		getLogin().click();
		
		return getInstance(HomePage.class);
	}
	
}
