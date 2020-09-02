package com.SwitchED.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwitchED.Generics.FileUtilities;

public class ClassRooms {
	
	public ClassRooms(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Coding')]")
	private WebElement codingClass;
	
	public void clickOnCodingClass(WebDriver driver)
	{
		codingClass.click();
		FileUtilities.verifyTextMessage(driver, "//a[contains(text(),'Automation Testing')]", "Automation Testing");
	}

}
