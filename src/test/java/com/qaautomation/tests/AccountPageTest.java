package com.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qaautomation.pages.AccountPage;
import com.qaautomation.pages.HomePage;
import com.qaautomation.pages.LoginPage;
import com.qaautomation.pages.RegisterPage;
import com.qaautomation.testbase.TestBase;
import com.qaautomation.utilities.TestUtils;

public class AccountPageTest extends TestBase {

 

	LoginPage loginpage;
	HomePage homepage;
	AccountPage accountpage;
	TestUtils testutils;
	RegisterPage registerPage;

	@Test
	public void DoVerifyUsername() throws Exception {

		test.log(Status.INFO, "Initilising the driver");
		
		
		homepage = new HomePage(driver);
		testutils = new TestUtils(driver);

		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on NO THANKS button");
		homepage.clickNoThankButton();

		String username = testutils.getRandomString();
		String email = testutils.getRandomString() + "@gmail.com";
		String password = testutils.getRandomString();
		
		test.log(Status.INFO, "Clicking on register page link");
		registerPage = homepage.clickOnRegisterLink();
		
		test.log(Status.INFO, "Entering username, email, password and confrim password which genrated randomly");
		accountpage = registerPage.doRegister(username, email, password);

		test.log(Status.INFO, "Register done successfully");
		System.out.println(accountpage.doVerifyProfileName());
		
		test.log(Status.INFO, "Verifying the  profile name  is same as username");
		Assert.assertEquals(username, accountpage.doVerifyProfileName());

		
		test.log(Status.INFO, "Printing all the cources namer on account page");
		accountpage.getCountOfAllCources();

	}

}
