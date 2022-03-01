package com.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void verifyLoginPageTilteTest() {
		String LoginTitle = page.getInstance(LoginPage.class).verifyLoginTitle();
		Assert.assertEquals(LoginTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void VerifyReturnLinkTest() throws InterruptedException {
		page.getInstance(LoginPage.class).VerifyReturnLink();
		Thread.sleep(2000);
		String returnTitle = driver.getTitle();
		Assert.assertEquals(returnTitle, "Return Policy - Flipkart.com");
	}
	
	@Test(priority = 3)
	public void VerifyHomeDropdownListTest() throws InterruptedException {
		page.getInstance(LoginPage.class).VerifyHomeDropdownList();
	}
	
	@Test(priority = 4)
	public void searchBoxItemTest() throws InterruptedException {
		page.getInstance(LoginPage.class).searchBoxItem();
	}
	
	@Test(priority = 5)
	@Parameters({"email","password"})
	public void doLoginTest(String em,String pwd) throws InterruptedException {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(em, pwd);
		String homePageTitle=  homePage.getInstance(HomePage.class).getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
}
