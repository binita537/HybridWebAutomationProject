package com.qaautomation.pagebase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	
	
	protected WebDriver driver;
	public JavascriptExecutor executor ;
	
	protected PageBase(WebDriver driver)
	{
	    this.driver=driver;
	}

	
	public  void clickByJS(WebElement element) {			
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public WebElement getWebElement(By Locator)
	{
	  return driver.findElement(Locator);
		
	}

	public void clickByJS(By Locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(Locator));
	}
	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {

		try {
			element = new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("Element has not been  clickable , searched by element" + e);
			return null;
		}
		return element;

	}

	public WebElement waitForElementToBePresent(WebDriver driver, WebElement element) {

		try {
			element = new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println("Element has not been visible, searched by element" + e);
			return null;
		}
		return element;

	}

	
	
	
	
	
}
