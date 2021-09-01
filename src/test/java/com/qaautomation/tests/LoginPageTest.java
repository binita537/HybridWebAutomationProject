package com.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qaautomation.pages.AccountPage;
import com.qaautomation.pages.HomePage;
import com.qaautomation.pages.LoginPage;
import com.qaautomation.testbase.TestBase;
import com.qaautomation.utilities.TestUtils;
public class LoginPageTest extends TestBase {

	 private WebDriver driver;

	

	LoginPage loginpage;
	HomePage homepage;
	AccountPage accountpage;
	TestUtils testutils;
	

	
	@Test
	public void doLoginWithCredentail() throws Exception {
		

		driver = getDriver();
		test.log(Status.INFO, "Initilising the driver");
		testutils = new TestUtils(driver);
		Thread.sleep(2000);
		homepage = new HomePage(driver);
		test.log(Status.INFO, "Clicking on NO THANKS button");
		homepage.clickNoThankButton();
		

		test.log(Status.INFO, "Clicking on Login button");
		loginpage = homepage.clickOnLoginButton();
		System.out.println(property.getProperty("username"));
		System.out.println(property.getProperty("password"));
		
		test.log(Status.INFO, "Logging the application with username and password");
		accountpage = loginpage.doLogin(property.getProperty("username"), property.getProperty("password"));
		
		test.log(Status.INFO, "Logged in successfully");

	}

	

}
