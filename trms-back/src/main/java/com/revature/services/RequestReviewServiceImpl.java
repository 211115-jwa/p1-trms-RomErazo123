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
		Set<Reimbursement> requests = reqDao.getAll();

		Set<Reimbursement> reque = new HashSet<>(); 
		for (Reimbursement request :requests) { 
			if(request.getStatus().getName().contains("Pending")) { 
				reque.add(request); 
			} // End if
		} // End For .contains(statusDao.getByName("Pending"))
		requests = reque;

		/*
		 * requests.forEach(req -> { req.setRequestor(approver); });
		 */	  
		return requests;
	}

	@Override
	public void approveRequest(Reimbursement request) {
		Status st = new Status();
		st.setStatusId(2);
		if (reqDao.getById(request.getReqId()) != null) {
			request.setStatus(st);
			reqDao.update(request);
		}

	}

	@Override
	public void rejectRequest(Reimbursement request) {
		Status st = new Status();
		st.setStatusId(3);
		if (reqDao.getById(request.getReqId()) != null) {
			request.setStatus(st);
			reqDao.update(request);
		}

	}

	@Override
	public void rejectRequest(Reimbursement request, Comment comment) {
		Status st = new Status();
		st.setStatusId(3);
		if (reqDao.getById(request.getReqId()) != null) {
			request.setStatus(st);
			reqDao.update(request);
			
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
