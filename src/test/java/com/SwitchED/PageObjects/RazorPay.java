package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RazorPay {
	
	public RazorPay(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='details show-desktop-screen']//input[@class='razorpay-payment-button']")
	private WebElement paynow;
	
	@FindBy(id = "contact")
	private WebElement phoneNumber;
	
	@FindBy(id= "email")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id=\"footer-cta\"]")
	private WebElement proceed;
	
	@FindBy(xpath = "/html/body/div[3]/iframe")
	private WebElement iframeMob;
	
	@FindBy(xpath = "/html/body/div[3]/iframe")
	private WebElement iframeEmail;
	
	public void clickOnPayNow()
	{
		paynow.click();
	}
	
	public void enterPhoneNumber(WebDriver driver,String Mob) throws InterruptedException
	{
		driver.switchTo().frame(iframeMob);
		Thread.sleep(2000);
		phoneNumber.clear();
		phoneNumber.sendKeys(Mob);
	}
	
	public void enterEmailAddress(WebDriver driver, String email) throws InterruptedException
	{
		driver.switchTo().frame(iframeEmail);
		Thread.sleep(2000);
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	
	public void clickOnProceed(WebDriver driver)
	{
		driver.switchTo().frame(iframeEmail);
		proceed.click();
	}

}
