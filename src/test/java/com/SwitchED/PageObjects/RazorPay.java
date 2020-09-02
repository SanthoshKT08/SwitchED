package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

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
	
	@FindBy(xpath = "//*[@id=\"form-common\"]/div[1]/div/div/div[2]/div/div/button[3]/div/div/div[1]")
	private WebElement netBanking;
	
	@FindBy(xpath = "//*[@id=\"bank-item-SBIN\"]/label/div/img")
	private WebElement SBI;
	
	@FindBy(xpath = "//*[@id=\"footer\"]/span[2]")
	private WebElement Pay;
	
	public void clickOnPayNow()
	{
		paynow.click();
	}
	
	public void enterPhoneNumber(WebDriver driver,String Mob) throws InterruptedException
	{
		Thread.sleep(1000);
		phoneNumber.clear();
		phoneNumber.sendKeys(Mob);
	}
	
	public void enterEmailAddress(WebDriver driver, String email) throws InterruptedException
	{
		Thread.sleep(1000);
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	
	public void clickOnProceed(WebDriver driver)
	{ 
		proceed.click();
	}
	
	public void clickOnNetBanling()
	{
		netBanking.click();
	}
	
	public void clickOnSBI(WebDriver driver)
	{
		FileUtilities.handleElementClickInterceptedException(driver, SBI);
	}
	
	public void ClickOnPay()
	{
		Pay.click();
	}

}
