package com.qaautomation.pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaautomation.utilities.TestUtils;

public class HomePage  {

	
	 public WebDriver driver;
	

	/*
	 * All the WebElelemts for login page
	 */

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[1]")
	private WebElement HOMELINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[2]")
	WebElement COURSELINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[3]")
	WebElement VIDEOLINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[4]")
	WebElement INTEVIEWGUIDELINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[5]")
	WebElement PRACTISELINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[6]")
	WebElement BLOGLINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[7]")
	WebElement ABOUTLINK;

	@FindBy(xpath = "//nav[@class='navbar-collapse collapse']/ul/li[8]")
	WebElement CONTACTLINK;

	@FindBy(xpath = "//div[@class='marquee0']")
	WebElement SlidingBar;

	@FindBy(xpath = "//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']")
	WebElement BannerText;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement ApplicxationLogo;

	@FindBy(xpath = "//div[@class='text-center']")
	WebElement FeaturedCources;

	@FindBy(xpath = "//ul[@class='gallery course-list']")
	List<WebElement> ListOfCourcesOnHomePage;

	@FindBy(xpath = "//button[text()='NO THANKS']")
	WebElement NoThanksLink;

	@FindBy(xpath = "//a/span[text()='Login']")
	WebElement LoginLink;

	@FindBy(xpath = "//a/span[text()='Register']")
	WebElement ResgisterLink;

	/*
	 * initilise all the WebElelemts for login page
	 */

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	TestUtils testutil = new TestUtils(driver);

	/*
	 * ALl the action methods related tp login page
	 */

	public LoginPage clickOnLoginButton() {
		testutil.waitForElementToBeClickable(driver,LoginLink).click();
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterLink() {
		testutil.waitForElementToBeClickable(driver, ResgisterLink).click();
		return new RegisterPage(driver);
	}

	public void clickNoThankButton() {

		testutil.waitForElementToBeClickable(driver,NoThanksLink).click();
	}

	
	public String getTitle() {
		
		
		return driver.getTitle();
	}

	
	public String getTextFromSilidingBar() {
		
		return testutil.waitForElementToBePresent(driver,SlidingBar).getText();
		
	}

	
	public String doVerifyBannerText() {
		return testutil.waitForElementToBePresent(driver, BannerText).getText();
		
	}

	
	public boolean doVerifyLogoIsDisplayed() {
		
		return testutil.waitForElementToBePresent( driver,ApplicxationLogo).isDisplayed();
		
	}
	
	public String doVerifyTheFeaturedCourcesText() {
		
		return testutil.waitForElementToBePresent(driver, FeaturedCources).getText();
		
	}

	
	public void getAllCOurcesOnHomePage() {
		
		 testutil.waitForElementToBePresent(driver, FeaturedCources);
		int size = ListOfCourcesOnHomePage.size();

		for (int i = 0; i < size; i++) {
			ListOfCourcesOnHomePage.get(i).getText();

		}

	}

}
