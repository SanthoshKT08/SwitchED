package com.SwitchED.PageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class SignUpPage {
	
	public SignUpPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"wrap\"]/div/div/div/div/div/div/div/form/div[1]/div/div[1]/label")
	private WebElement studentRadioBtn;
	
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastNameFied;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//label[@class='form-check-label']")
	private WebElement checklist;
	
	@FindBy(xpath = "//*[@id=\"Ut1\"]/div[4]/button")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//*[@id=\"Ut1\"]/div[3]/div/label/a")
	private WebElement termsAndConditionlink;
	
	@FindBy(xpath = "//a[contains(text(),'Login here')]")
	private WebElement loginHereLink;
	
	public void selectStudioRadioBtn()
	{
		studentRadioBtn.click();
	}
	
	public void enterTheFirstName(String firstName)
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void enterTheLastName(String lastName)
	{
		lastNameFied.sendKeys(lastName);
	}
	
	public void enterEmailAdress(String leftmail, int ran, String rightmail)
	{
		
		emailField.sendKeys(leftmail+ran+rightmail);
	}
	
	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}
	
	public void clickOnCheckList()
	{
		checklist.click();
	}
	
	public void clickOnRegister()
	{
		registerBtn.click();
	}
	
	public void verifyRegisterThankYouPage(WebDriver driver)
	{
		FileUtilities.verifyTextMessage(driver,"//h3[contains(text(),'Thank you for registering with SwitchED.')]" , "Thank you for registering with SwitchED.");
	}
	
	public void clickOnTermsAndCondition(WebDriver driver)
	{
		termsAndConditionlink.click();
		FileUtilities.verifyTextMessage(driver, "//h2[contains(text(),'Terms of Use')]", "Terms of Use");
	}
	
	public void clickOnLoginHereLink(WebDriver driver)
	{
		FileUtilities.handleExplicitWait(driver, "//a[contains(text(),'Login here')]");
		loginHereLink.click();
		FileUtilities.verifyTextMessage(driver, "//h3[contains(text(),'Sign into your account')]", "Sign into your account");
	}
	
	

}
