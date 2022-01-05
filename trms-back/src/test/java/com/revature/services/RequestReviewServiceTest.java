package com.revature.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Comment;
import com.revature.beans.Department;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.ReimbursementDAO;

@ExtendWith(MockitoExtension.class)
public class RequestReviewServiceTest {
	@Mock
	private CommentDAO cmtDao;

	@Mock
	private EmployeeDAO empDao;

	@Mock
	private ReimbursementDAO reimDao;

	private static Set<Department> mockDept;
	private static Set<Employee> mockEmployee;
	private static Set<Reimbursement> mockReimbursement;
	private static Set<Comment> mockComment;


	@InjectMocks
	private RequestReviewService rrServ = new RequestReviewServiceImpl();

	@BeforeAll // Filling or creating the Mock 
	public static void mockSetupComment() {
		mockComment = new HashSet <> ();// Create the mock

		for (int i=1; i<=2; i++) {
			Comment c = new Comment();

			c.setCommentId(i);
			c.setCommentText("Test");

			c.setRequest(new Reimbursement());
			c.getRequest().setReqId(i);

			c.setApprover(new Employee());
			c.getApprover().setEmpId(i);
			mockComment.add(c);
		}// End of Filling up the Mock
	}// End of mockSetup


	@BeforeAll // Filling or creating the Mock 
	public static void mockSetupDepartment() {
		mockDept = new HashSet <> ();// Create the mock
		Department d = new Department();
		d.setDeptId(1);
		d.setDeptHeadId(24);
		d.setName("Test Name");
		mockDept.add(d);
	}// End of mockSetup

	@BeforeAll
	public static void mockSetupReimbursement() {

		mockReimbursement = new HashSet<> (); // Create the Mock

		for (int i=1; i<=5; i++) { 
			Employee employee = new Employee();
			employee.setEmpId(i);

			Reimbursement reimbursement = new Reimbursement();

			reimbursement.setReqId(i); 
			reimbursement.setRequestor(employee);
			reimbursement.getStatus().setStatusId(i);
			mockReimbursement.add(reimbursement);
		}// End of Filling up the Mock
	}// End of mockSetup


	@BeforeAll // Filling or creating the Mock 
	public static void mockSetupEmployee() {

		mockEmployee = new HashSet <> ();// Create the mock		

		for (int i=1; i<=4; i++) {
			Employee employee = new Employee();
			employee.setEmpId(i);
			employee.setFirstName("Test" + i);
			employee.setLastName("Test" + i);
			employee.setUsername("Test" + i);
			employee.setPassword("Test" + i);
			employee.setFunds(1000.0);
			if (i<=3)
				employee.getSupervisor().setEmpId(3);
			else employee.getSupervisor().setEmpId(2);
			employee.getRole().setRoleId(i);
			mockEmployee.add(employee);
		}// End of Filling up the Mock
	}// End of mockSetup

	///////////////////////////////////////////////////////////////////////


	@Test
	public void approveRequestNotSuccessfull() {
		Reimbursement rei = new Reimbursement();
		rei.setReqId(1);

		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));
		when(reimDao.getById(1)).thenReturn(rei);

		rrServ.rejectRequest(rei);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}


	@Test
	public void rejectRequestNotSuccessfull() {
		Reimbursement rei = new Reimbursement();
		rei.setReqId(1);

		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));
		when(reimDao.getById(1)).thenReturn(rei);

		rrServ.rejectRequest(rei);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}


	@Test
	public void rejectRequestCommentNotSuccessfull() {
		Comment comm = new Comment();
		comm.setCommentId(1);

		Reimbursement rei = new Reimbursement();
		rei.setReqId(1);

		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));
		when(reimDao.getById(1)).thenReturn(rei);

		rrServ.rejectRequest(rei, comm);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}


	@Test
	public void rejectRequestSuccessfully() {
		//rrServ
		Reimbursement request = new Reimbursement();
		Status st = new Status();
		st.setStatusId(3);
		request.setStatus(st);
		request.setReqId(1);

		when(reimDao.getById(request.getReqId())).thenReturn(request);
		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));

		rrServ.rejectRequest(request);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}


	@Test
	public void rejectRequestCommentSuccessfully() {
		Reimbursement request = new Reimbursement();
		Status st = new Status();
		st.setStatusId(3);
		request.setStatus(st);
		request.setReqId(1);

		Comment comm = new Comment();
		comm.setCommentId(1);

		when(reimDao.getById(request.getReqId())).thenReturn(request);
		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));

		rrServ.rejectRequest(request, comm);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}


	@Test
	public void approveRequestSuccessfully() {
		Reimbursement request = new Reimbursement();
		Status st = new Status();
		st.setStatusId(3);
		request.setStatus(st);
		request.setReqId(1);

		when(reimDao.getById(request.getReqId())).thenReturn(request);
		doNothing().when(reimDao).update(Mockito.any(Reimbursement.class));

		rrServ.rejectRequest(request);
		verify(reimDao).update(Mockito.any(Reimbursement.class));
	}

	@Test
	public Set<Reimbursement> getPendingReimbursementsSuccessfully(){
		Employee e = new Employee();
		Set<Reimbursement> requests = rrServ.getPendingReimbursements(e);
		when(empDao.getById(e.getEmpId())).thenReturn(e);

		return requests;
	}

}// End of Class




