package com.qaautomation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qaautomation.pages.AccountPage;
import com.qaautomation.pages.HomePage;
import com.qaautomation.pages.RegisterPage;
import com.qaautomation.testbase.TestBase;
import com.qaautomation.utilities.DataProviderUtitlities;
import com.qaautomation.utilities.TestUtils;
public class RegisterPageTest extends TestBase {


	
	private WebDriver driver;
	
	RegisterPage registerPage;
	AccountPage accountpage;
	HomePage homepage;
	TestUtils testutils;
	
	

	
	@Test(dataProvider ="commonDataProvider",dataProviderClass = DataProviderUtitlities.class)	
	public void doRegisterWithData(String username, String email, String password, String confirmpassword)
			throws InterruptedException {
		
		
		test.log(Status.INFO, "Initilising the driver");
		driver = getDriver();

		testutils = new TestUtils(driver);
		homepage = new HomePage(driver);
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on NO THANKS button");
		homepage.clickNoThankButton();

		test.log(Status.INFO, "Clicking on register page link");
		registerPage = homepage.clickOnRegisterLink();
		
		test.log(Status.INFO, "Entering username, email, password and confrim password from excel file");
		accountpage = registerPage.doRegister(username, email, password, confirmpassword);
		
		test.log(Status.INFO, "Register done successfully");
		Thread.sleep(20000);
		System.out.println(accountpage.doVerifyProfileName());
		test.log(Status.INFO, "Verifying the  profile name  is same as username");
		Assert.assertEquals(username, accountpage.doVerifyProfileName());

	}

	

}
