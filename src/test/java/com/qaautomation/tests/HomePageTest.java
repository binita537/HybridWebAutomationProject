package com.qaautomation.tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qaautomation.pages.HomePage;
import com.qaautomation.testbase.TestBase;


public class HomePageTest extends TestBase {

	

   HomePage homepage;



	@Test
	public void DoVerifyHomePage() throws Exception {

		test.log(Status.INFO, "Initilising the driver");
		
		

		homepage = new HomePage(driver);
		Thread.sleep(2000);
		test.log(Status.INFO, "Clicking on NO THANKS button");
		homepage.clickNoThankButton();

		test.log(Status.INFO, "Verifing the Logo is displayed or Not");
		homepage.doVerifyLogoIsDisplayed();
		
		test.log(Status.INFO, "Getting the title of the page");
		homepage.getTitle();
		
		test.log(Status.INFO, "Verifing the Banner text of the website");
		homepage.doVerifyBannerText();
		
		test.log(Status.INFO, "Verifing the Feature course text of the website");
		homepage.doVerifyTheFeaturedCourcesText();
		
		test.log(Status.INFO, "Getting the text from sliding bar");
		homepage.getTextFromSilidingBar();
		
		test.log(Status.INFO, "Getting the name of the all the courses on Home Page");
		homepage.getAllCOurcesOnHomePage();

	}

	

}
