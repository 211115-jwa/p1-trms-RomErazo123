Feature: Tuition Reimbursement Approval Management System

	Scenario Outline: Getting the approval of the Supervisor/Head
	
		Given get Pending Reimbursements from Employee needs or waiting for approval or rejection
		When Supervisor or Head approves Tuition Reimbursement
		And Can request additional information for Reimbursement
		Then Submit the Reimbursement Request	
		
	Scenario: Getting the rejection of the Supervisor/Head
	
		Given get Pending Reimbursements from employee needs or waiting for approval or rejection
		When Supervisor or Head rejects Tuition Reimbursement
		And Can request additional information
		And Can add additional information as a Comment
		Then Submit the Reimbursement Request
		
	Scenario: Getting the Benefits Coordinator rejection
	
		Given get Pending Reimbursements from employee needs or waiting for rejected or approve by BenCo
		When BenCo reject Tuition Reimbursement
		And Can request additional information
		And Can add additional information as a Comment
		Then Submit the Reimbursement Request
		
	Scenario: Getting the Benefits Coordinator approval
	
		Given get Pending Reimbursements from employee needs or waiting for rejected or approve by BenCo
		When BenCo approve Tuition Reimbursement
		And Can request additional information
		Then Submit the Reimbursement Request
		