package com.qaautomation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qaautomation.utilities.TestUtils;

public class AccountPage  {

	private WebDriver driver;

	/*
	 * All the WebElelemts for login page
	 */

	String BeforeXapth = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[";
	String AfterXpath = "]//a[@class='fedora-navbar-link navbar-link']";

	@FindBy(xpath = "//span[@class='navbar-current-user']")
	WebElement ProfileName;

	String Xapth = BeforeXapth + "1" + AfterXpath;
	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[1]//a[@class='fedora-navbar-link navbar-link']")
	WebElement HomeLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[2]//a[@class='fedora-navbar-link navbar-link']")
	WebElement AllCoursesLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[3]//a[@class='fedora-navbar-link navbar-link']")
	WebElement MyCoursesLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[4]//a[@class='fedora-navbar-link navbar-link']")
	WebElement LifeTimeAccessLInk;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[5]//a[@class='fedora-navbar-link navbar-link']")
	WebElement MentorshipLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[6]//a[@class='fedora-navbar-link navbar-link']")
	WebElement ConsultingLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[7]//a[@class='fedora-navbar-link navbar-link']")
	WebElement PracticeLink;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[8]//a[@class='fedora-navbar-link navbar-link']")
	WebElement AboutLink;

	@FindBy(xpath = "//a[@class='fedora-navbar-link navbar-link dropdown-toggle open-my-profile-dropdown']")
	WebElement MyProfileLink;

	@FindBy(xpath = "//li[@class='dropdown open']//ul[@class='dropdown-menu']//li")
	WebElement AllDropDownFromProfileLinke;

	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-md-4']")
	List<WebElement> AllCourcesOnAccountPage;

	@FindBy(xpath = "//input[@id='search-courses']")
	WebElement SearchCourcesField;

	@FindBy(xpath = "//button[@id='search-course-button']")
	WebElement SearchCourcesButton;

	/*
	 * initilise all the WebElelemts for login page
	 */

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	TestUtils testutil = new TestUtils(driver);

	/*
	 * ALl the action methods related tp login page
	 */

	public String doVerifyProfileName() {

		
		String Profilename=testutil.waitForElementToBePresent(driver, ProfileName).getText();
		//Profilename=Profilename.substring(0,1).toUpperCase()+Profilename.substring(1,Profilename.length()-1);
		return Profilename;

	}


	public void getCountOfAllCources() {
		int size = AllCourcesOnAccountPage.size();

		for (int i = 0; i < size; i++) {
			System.out.println(AllCourcesOnAccountPage.get(i).getText());
		}

	}

	
	public void searchCources(String CourceName) {
		testutil.waitForElementToBePresent(driver, SearchCourcesField).sendKeys(CourceName);
		testutil.waitForElementToBePresent(driver, SearchCourcesButton).click();

	}

}
