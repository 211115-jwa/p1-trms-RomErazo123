Feature: Tuition Reimbursement Approval Management System

	Scenario Outline: Submitting a Reimbursement Request
	
		Given The user is on the web page
		When The user enters all field to submit Reimbursement Request
		Then Submit the Reimbursement Request by Clicking Submit
		
	Scenario Outline: Showing all the pending Reimbursement
	
		Given The user is on the web page
		When The user enters employee_id 
		Then Get the Employee list of pending reimbursement request by Clicking Show 
		
		