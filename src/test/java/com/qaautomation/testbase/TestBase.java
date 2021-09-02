package com.qaautomation.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qaautomation.utilities.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public Properties property;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static ExtentReports extent;
	public  static ExtentSparkReporter htmlrepoter;
	public  static ExtentTest test;

	public TestBase() {

		property = new Properties();
		try {
			FileInputStream FIS = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/PropertiesFiles/Config.properties");
			property.load(FIS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void setReport() {

		if (extent == null) {
			extent = new ExtentReports();
			htmlrepoter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/src/test/resources/ExtentReports/TestReport.html");
			extent.attachReporter(htmlrepoter);
		}

	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}

	@BeforeMethod
	public WebDriver initialization(Method method) {

		String browserName = property.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Please mention right driver");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		tdriver.set(driver);

		driver.get(property.getProperty("Url"));
		
		

		test = extent.createTest(method.getName());

		return getDriver();

	}

	public static WebDriver getDriver() {
		
		return tdriver.get();
	}

	@AfterMethod
	public void quiteBrowser(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "   " + "  FAILED", ExtentColor.RED));
			String ScreenShotPath=TestUtils.getScreenShots(driver,result.getName());
			test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotPath).build());
		
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "   " + "  PASSED", ExtentColor.GREEN));

		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "   " + "  SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());

		}

		driver.quit();
	} 

}
