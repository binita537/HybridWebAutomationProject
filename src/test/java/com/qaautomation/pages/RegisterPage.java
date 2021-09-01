package com.qaautomation.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qaautomation.utilities.TestUtils;

public class RegisterPage {

	
	public WebDriver driver;
	
	
	
	/*
	 * All the WebElelemts for login page
	 */
	
	

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement  FullName;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement   EmailAddress;

	@FindBy(xpath = "//input[@id='user_password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id='user_password_confirmation']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//input[@id='user_unsubscribe_from_marketing_emails']")
	WebElement FirstCheckBox;

	@FindBy(xpath ="//input[@id='user_agreed_to_terms']")
	WebElement    SecondCheckBox;

	
	
	//span[@class='navbar-current-user']
	
	/*
	 * initilise all the WebElelemts for login page
	 */

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	TestUtils testutil = new TestUtils(driver);
	
	/*
	 * ALl the action methods related tp login page 
	 */

	

	
	public AccountPage   doRegister(String   FN,String EM,String  PWD,String CPWD) 
	{
		
		testutil.waitForElementToBePresent(driver, FullName).sendKeys(FN);
		testutil.waitForElementToBePresent(driver, EmailAddress).sendKeys(EM);
		testutil.waitForElementToBePresent(driver, Password).sendKeys(PWD);
		testutil.waitForElementToBePresent(driver, ConfirmPassword).sendKeys(CPWD);
		testutil.waitForElementToBeClickable(driver, FirstCheckBox).click();
		testutil.waitForElementToBeClickable(driver, SecondCheckBox).click();
		testutil.waitForElementToBeClickable(driver, SubmitButton).click();
		
			return new AccountPage(driver);
		
		
	}
	
	public AccountPage   doRegister(String   FN,String EM,String  PWD) 
	{
		
		testutil.waitForElementToBePresent(driver, FullName).sendKeys(FN);
		testutil.waitForElementToBePresent(driver, EmailAddress).sendKeys(EM);
		testutil.waitForElementToBePresent(driver, Password).sendKeys(PWD);
		testutil.waitForElementToBePresent(driver, ConfirmPassword).sendKeys(PWD);
		testutil.waitForElementToBeClickable(driver, FirstCheckBox).click();
		testutil.waitForElementToBeClickable(driver, SecondCheckBox).click();
		testutil.waitForElementToBeClickable(driver, SubmitButton).click();
		
			return new AccountPage(driver);
		
		
	}
	
	
	
	
	



}
