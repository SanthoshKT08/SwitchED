package com.SwitchED.Generics;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUtilities {

	public static String getScreenShot(WebDriver driver, String name)
	{
		TakesScreenshot Ts =(TakesScreenshot) driver;

		File src = Ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"/Screenshots/"+name+".png";

		File des = new File(path);

		try 
		{
			FileUtils.copyFile(src, des);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

		return path;
	}
	
	public static String getScreenShotBase64(WebDriver driver, String name) //Image can open in  any where..
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String imageOutput = ts.getScreenshotAs(OutputType.BASE64);
		
		return imageOutput;
	}


	public static void getWindowsHandles(WebDriver driver, int tab) throws InterruptedException
	{	
		Thread.sleep(2000);

		Set<String> allWindows = driver.getWindowHandles();

		ArrayList<String> tabs = new ArrayList<String>(allWindows);

		driver.switchTo().window(tabs.get(tab));
	}


	public static void scrollPage(WebDriver driver, String Pixel, String empty)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;

		js.executeScript(Pixel,empty);
	}

	public static void actionClass(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void dropDownField(WebElement locXPath, String location)
	{
		Select locations = new Select(locXPath);
		locations.selectByValue(location);
	}

	public static void handleElementClickInterceptedException(WebDriver driver, WebElement ele )
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public static void scrollUntilElementFind(WebDriver driver, WebElement ScrollElement)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();", ScrollElement);
	}

	public static void verifyTitlePage(WebDriver driver, String expectedTitle)
	{
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.titleIs(expectedTitle));

		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Title is matching");
	}

	public static void verifyTextMessage(WebDriver driver, String Xpath, String enterExpectedText)
	{
		WebElement textMessage = driver.findElement(By.xpath(Xpath));
		
		String ExpectedText = enterExpectedText;

		String ActualText=textMessage.getText();
		
		if(ActualText.equals(ExpectedText))
		{
			Assert.assertEquals(ActualText, ExpectedText);
			System.out.println("Text is present");
		}
		else
		{
			System.out.println("Text is not present");
			Assert.fail();
		}

	}
	
	public static void sendMailReport() throws EmailException
	{
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(System.getProperty("user.dir")+"/htmlReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Automation Testing");
		attachment.setName("suman");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(456);
		email.setAuthenticator(new DefaultAuthenticator("ktsanthosh08@gmail.com", "1@santhoshkt"));
		email.setSSLOnConnect(true);
		email.addTo ("sumans1826@gmail.com", "suman");
		email.setFrom("ktsanthosh08@gmail.com", "santhosh");
		email.setSubject("Report");
		email.setMsg("Test Report");
		email.attach(attachment);
		email.send();
	}
	
	public static void handleExplicitWait(WebDriver driver, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	


}
