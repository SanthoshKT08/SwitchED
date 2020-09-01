package com.SwitchED.Generics;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports reports;

	public static ExtentTest test;

	public static ReadConfigProperties pronote = new ReadConfigProperties();

	public static Logger logger = LogManager.getLogger(Baseclass.class);

	@BeforeSuite
	public static void reportSetup()
	{
		logger.info("Extet report setup is execute...");
		//String timeStamp =new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		//htmlReporter = new ExtentHtmlReporter("./ExtentReports/"+timeStamp+"-ExtentReport.html");
		htmlReporter = new ExtentHtmlReporter("htmlReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("SwitchED - Automation Testing");
		htmlReporter.config().setReportName("SwitchED - Functionality Testing");
		reports.setSystemInfo("Quality Assurance", "Santhosh KT");
		reports.setSystemInfo("Project", "SwitchED");
		reports.setSystemInfo("Platfrom", "Windows 10");
		reports.setSystemInfo("Device", "Hp");
		htmlReporter.loadXMLConfig("./Extent-Config.xml"); 
		logger.info("extent report setup is done");
	}

	@Parameters("browsersNames")
	@BeforeTest
	public static void browserSetup(String browsers)
	{
		logger.info("Chrome browser is gonna launch.");

		if(browsers.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get(pronote.getUrl());

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
		}


		else if (browsers.equalsIgnoreCase("firefox")) {

			logger.info("Firefox browser is gonna launch.");

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			driver.get(pronote.getUrl());

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();

		}

	}

	@AfterMethod
	public static void getITestReults(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.info("TestCases is pass.");
			test.log(Status.PASS, result.getName());
			reports.setTestRunnerOutput(result.getName());
			test.createNode(result.getName());
		}

		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			logger.info("TestCases is fail.");
			test.log(Status.FAIL, result.getThrowable());
			//String capture=FileUtilities.getScreenShot(driver, result.getName());
			//test.addScreenCaptureFromPath(capture); // Normal screen attachement..
			String image=FileUtilities.getScreenShotBase64(driver, result.getName());
			test.addScreenCaptureFromBase64String(image);
			reports.setTestRunnerOutput(result.getName());
		}

		else if (result.getStatus()==ITestResult.SKIP) 
		{
			logger.info("TestCases is Skip.");
			test.log(Status.SKIP, result.getThrowable());
			reports.setTestRunnerOutput(result.getName());
		}
	}

	@AfterTest
	public static void browserEnd()
	{
		//logger.info("Browser is closed");

		//driver.close();
	}


	@AfterSuite
	public static void reportEnd() throws EmailException
	{

		reports.flush();

		logger.info("Extent report flush is done");

		//FileUtilities.sendMailReport();

		//logger.info("Mail sent");
	}

}
