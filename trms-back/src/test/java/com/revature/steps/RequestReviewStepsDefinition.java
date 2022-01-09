package com.revature.steps;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.app.TRMSApp;
import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.RequestReviewService;
import com.revature.services.RequestReviewServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestReviewStepsDefinition {
	
	Employee employee = new Employee();
	Reimbursement reimbursement = new Reimbursement();
	
	RequestReviewService rServ = new RequestReviewServiceImpl();
	private EmployeeService eServ = new EmployeeServiceImpl();
	
	private ReimbursementDAO reimDao;
	private EmployeeDAO empDao;
	
	private CommentDAO cmtDao;
	

	@When("Can add additional information as a Comment")
	public void can_add_additional_information_as_a(Comment comment) {
		
		eServ.addComment(comment);
	}

	
	@Given("get Pending Reimbursements from employee needs or waiting for approval or rejection")
	public void get_pending_reimbursements_from_employee_needs_or_waiting_for_approval_or_rejection
	(Employee employee) {
		
	    rServ.getPendingReimbursements(employee);
	}
	

	@When("Can request additional information")
	public void can_request_additional_information(Reimbursement reimbursement) {
		
		eServ.getComments(reimbursement);
	}
	
	@When("Supervisor or Head approves Tuition Reimbursement")
	public void supervisor_or_head_approves_tuition_reimbursement(Reimbursement reimbursement) {
		
		rServ.approveRequest(reimbursement);
	}

	@When("Supervisor or Head rejects Tuition Reimbursement")
	public void supervisor_or_head_rejects_tuition_reimbursement(Reimbursement reimbursement) {
		rServ.rejectRequest(reimbursement);
	}


	@Given("get Pending Reimbursements from employee needs or waiting for rejected or approve by BenCo")
	public void get_pending_reimbursements_from_employee_needs_or_waiting_for_rejected_or_approve_by_ben_co
	(Employee employee) {
	    
		rServ.getPendingReimbursements(employee);
	}

	@When("BenCo reject Tuition Reimbursement")
	public void ben_co_reject_tuition_reimbursement(Reimbursement reimbursement) {
		
		rServ.rejectRequest(reimbursement);
	}

	@When("BenCo approve Tuition Reimbursement")
	public void ben_co_approve_tuition_reimbursement(Reimbursement reimbursement) {
	    
		rServ.approveRequest(reimbursement);
	}
	
	@Then("Submit the Reimbursement Request")
	public void submit_the_reimbursement_request(Reimbursement reimbursement) {
		
		eServ.submitReimbursementRequest(reimbursement);
	}
}
