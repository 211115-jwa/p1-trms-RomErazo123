package com.revature.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.beans.Employee;

public class TRMSpage {
	
	@FindBy(id="emp_id")
	WebElement empid;
	@FindBy(id="eventDate")
	WebElement evtD;
	@FindBy(id="eventTime")
	WebElement evtT;
	@FindBy(id="location")
	WebElement lct;
	@FindBy(id="description")
	WebElement desc;
	@FindBy(id="cost")
	WebElement cost;
	@FindBy(id="grading_id")
	WebElement grd;
	@FindBy(id="event_id")
	WebElement evtID;
	@FindBy(id="status_id")
	WebElement sts;
	
	
	private WebDriver driver;
	
	@FindBy(id="submitReimbursement")
	WebElement submitBtn;
	@FindBy(id="eim")
	WebElement employeeID;
	@FindBy(id="eimReimbursementAllList")
	WebElement showBtn;
	
	public TRMSpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo() {
		driver.get("file:///C:/Users/Admin/Desktop/Revature/2111-nov15-uta/p1-trms-RomErazo123/TRSMindex.html");
	}
	
	public void showButtonClick() {
		showBtn.click();
	}
	
	public void submitButtonClick() {
		submitBtn.click();
	}
	
	public void enterEmployee_id(int id) {
		employeeID.sendKeys(String.valueOf(id));
	}
	
	public void submitReimbursementRequest(int id, String location, String description, 
			String date, String time, double cos, int grid, int evtid, int stsid) {
		
		empid.sendKeys(String.valueOf(id));
		evtD.sendKeys(date);
		evtT.sendKeys(time);
		lct.sendKeys(location);
		desc.sendKeys(description);
		cost.sendKeys(String.valueOf(cos));
		grd.sendKeys(String.valueOf(grid));
		evtID.sendKeys(String.valueOf(evtid));
		sts.sendKeys(String.valueOf(stsid));

		submitBtn.click();
	}
}// End of Class



