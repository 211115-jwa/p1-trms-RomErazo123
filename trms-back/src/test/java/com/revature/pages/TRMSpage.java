package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TRMSpage {
	
	private WebDriver driver;

	public TRMSpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}// End of Class
