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
	
	
}// End of Class
