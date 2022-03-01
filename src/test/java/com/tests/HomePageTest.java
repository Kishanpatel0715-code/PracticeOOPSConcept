package com.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends BaseTest{

	@Test
	@Parameters({"email","password"})
	public void verifyMyaccountLinkTest(String em,String pwd) throws InterruptedException {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(em, pwd);
		boolean b = homePage.getInstance(HomePage.class).verifyMyaccountLink();
		Assert.assertTrue(b);
	}
}
