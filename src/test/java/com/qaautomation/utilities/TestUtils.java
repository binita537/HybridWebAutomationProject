package com.qaautomation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	private WebDriver driver;
	public WebDriverWait webElement;
	public Select select;
	JavascriptExecutor js;

	public TestUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollAtElemet(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollBottomOfPage(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollTopOfPage(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.document.body.scrollTop");
		
	}
	

	public void selectByIndexDropDown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValueDropDown(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleTextDropDown(WebElement element, String VisibleText) {
		select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}

	public static String getScreenShots(WebDriver driver, String FileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String FileDestination = System.getProperty("user.dir") + "\\FailedTestCases\\" + FileName + ".png";
		File destinationFile = new File(FileDestination);
		try {
			FileUtils.copyFile(Source, destinationFile);
		} catch (IOException e) {
			System.out.println("Capture Screenshot" +e.getMessage());
		}

		return FileDestination;
	}

	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {

		try {
			element = new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("Element has not been  clickable , searched by element" + e);
			return null;
		}
		return element;

	}

	public WebElement waitForElementToBePresent(WebDriver driver, WebElement element) {

		try {
			element = new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println("Element has not been visible, searched by element" + e);
			return null;
		}
		return element;

	}

	public String getRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(10);
	}

}
