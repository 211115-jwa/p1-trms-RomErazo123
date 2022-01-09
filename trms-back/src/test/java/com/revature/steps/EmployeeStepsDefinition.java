package com.revature.steps;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.EmployeeDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.pages.*;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.RequestReviewService;
import com.revature.services.RequestReviewServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeStepsDefinition {
	
	Employee employee = new Employee();
	Reimbursement reimbursement = new Reimbursement();
	
	RequestReviewService rServ = new RequestReviewServiceImpl();
	private EmployeeService eServ = new EmployeeServiceImpl();
	
	private ReimbursementDAO reimDao;
	private EmployeeDAO empDao;
	
	private  TRMSpage TRMSpage;
	private WebDriver driver;
	
	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		TRMSpage = new TRMSpage(driver);
	}
	
	@Given("The user is on the web page")
	public void the_user_is_on_the_web_page() {
	   
		driver.get("http://localhost:8080");
	}

	@When("The user enters all field to submit Reimbursement Request")
	public void the_user_enters_all_field_to_submit_reimbursement_request() {
		
		TRMSpage.submitReimbursementRequest(2, "Puerto Rico", "Description", 
				"2022-9-12", "11:11:35", 255.70, 1, 2, 3);
	}

	@Then("Submit the Reimbursement Request by Clicking Submit")
	public void submit_the_reimbursement_request_by_clicking_submit() {
	    
		TRMSpage.submitButtonClick();
	}

	@When("The user enters employee_id")
	public void the_user_enters_employee_id(int id) {
	    
		TRMSpage.enterEmployee_id(id);
	}

	@Then("Get the Employee list of pending reimbursement request by Clicking Show")
	public void get_the_employee_list_of_pending_reimbursement_request_by_clicking_show() {
	    
		TRMSpage.showButtonClick();
	}
	
}// End of Class
