package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class SignIn {
	
	public SignIn(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Register here')]")
	private WebElement registerLink;
	
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-slider blue-btn rounded-pill w-100']")
	private WebElement loginBtn;
	
	public void clickOnRegisterLink(WebDriver driver)
	{
		registerLink.click();
		FileUtilities.verifyTextMessage(driver, "//h3[contains(text(),'Create an account')]", "Create an account");
	}
	
	public void enterEmailAdress(String mail)
	{
		emailAddress.sendKeys(mail);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	


}
