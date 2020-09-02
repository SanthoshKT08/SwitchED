package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class ClassEnrol {
	
	public ClassEnrol(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='col-sm-12']//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//a[1]//span[1]")
	private WebElement enrol;
	
	public void clickOnEnrol(WebDriver driver)
	{
		FileUtilities.scrollPage(driver, "window.scrollBy(0,50)", "");
		FileUtilities.handleElementClickInterceptedException(driver, enrol);
		//enrol.click();
		FileUtilities.verifyTitlePage(driver, "Razorpay Payment");
	}

}
