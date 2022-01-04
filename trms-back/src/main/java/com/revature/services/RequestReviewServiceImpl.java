package com.revature.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.EventTypeDAO;
import com.revature.data.GradingFormatDAO;
import com.revature.data.ReimbursementDAO;
import com.revature.data.StatusDAO;
import com.revature.utils.DAOFactory;

public class RequestReviewServiceImpl implements RequestReviewService{

	private EventTypeDAO eventTypeDao = DAOFactory.getEventTypeDAO();
	private GradingFormatDAO gradFormatDao = DAOFactory.getGradingFormatDAO();
	private StatusDAO statusDao = DAOFactory.getStatusDAO();
	private ReimbursementDAO reqDao = DAOFactory.getReimbursementDAO();
	private CommentDAO commentDao = DAOFactory.getCommentDAO();
	private EmployeeDAO empDao = DAOFactory.getEmployeeDAO();

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Override
	public Set<Reimbursement> getPendingReimbursements(Employee approver) {
		Set<Reimbursement> requests = reqDao.getByRequestor(approver);

		Set<Reimbursement> reque = new HashSet<>(); 
		for (Reimbursement request :requests) { 
			if(((Set<Reimbursement>) request.getEventType()).contains(statusDao.getByName("Pending"))) { 
				reque.add(request); 
			} // End if
		} // End For 
		requests = reque;

		/*
		 * requests.forEach(req -> { req.setRequestor(approver); });
		 */	  
		return requests;
	}

	@Override
	public void approveRequest(Reimbursement request) {
		if (reqDao.getById(request.getReqId()) != null) {
			reqDao.update(request);
			request = reqDao.getById(request.getReqId());
		}

	}

	@Override
	public void rejectRequest(Reimbursement request) {
		if (reqDao.getById(request.getReqId()) != null) {
			reqDao.update(request);
			request = reqDao.getById(request.getReqId());
		}

	}

	@Override
	public void rejectRequest(Reimbursement request, Comment comment) {
		if (reqDao.getById(request.getReqId()) != null) {
			reqDao.update(request);
			request = reqDao.getById(request.getReqId());
			comment.setSentAt(LocalDateTime.now());
			commentDao.create(comment);
		}

	}
	
	/*
	 * @Override // returns a list 
	 * public Set<Reimbursement> searchByRequestor(Employee requestor) { 
	 * Set<Reimbursement> a =
	 * reqDao.getByRequestor(requestor); return a; 
	 * }
	 * 
	 * @Override // returns a list 
	 * public Set<Reimbursement> searchByStatus(Status status) { 
	 * Set<Reimbursement> a = reqDao.getByStatus(status); return a; 
	 * }
	 */

}
