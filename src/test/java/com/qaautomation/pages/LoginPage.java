package com.qaautomation.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qaautomation.utilities.TestUtils;


public class LoginPage {

	
	public WebDriver driver;
	
	
	
	
	/*
	 * All the WebElelemts for login page
	 */
	
	
	@FindBy(id = "user_email")
	WebElement UserEmail;

	@FindBy(id = "user_password")
	WebElement Password;

	@FindBy(name = "commit")
	WebElement Submit;

	@FindBy(xpath = "//a[@class='link-below-button']")
	WebElement ForgetPassword;

	@FindBy(xpath = "//button[text()='NO THANKS']")
	WebElement NoThanksLink;

	/*
	 * initilise all the WebElelemts for login page
	 */

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	TestUtils testutil = new TestUtils(driver);
	
	/*
	 * ALl the action methods related tp login page 
	 */




	
	public void enterUsername(String UN) {
		
		testutil.waitForElementToBePresent(driver,UserEmail).sendKeys(UN);
		
	}

	
	public void entrPassword(String PWD) {
		testutil.waitForElementToBePresent(driver, UserEmail).sendKeys(PWD);
		
	}


	public void clickOnSubmitButton() {
		
		testutil.waitForElementToBeClickable(driver, Submit).click();
		Submit.click();
	}
	
	

	public AccountPage doLogin(String username, String password) {
		enterUsername(username);
		entrPassword(password);
		clickOnSubmitButton();
		return new AccountPage(driver);
	}
	

}
