package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.CommentDAO;
import com.revature.data.EmployeeDAO;
import com.revature.data.ReimbursementDAO;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private CommentDAO cmtDao;

	@Mock
	private EmployeeDAO empDao;

	@Mock
	private ReimbursementDAO reimDao;

	private static Set<Employee> mockEmployee;
	private static Set<Reimbursement> mockReimbursement;
	
	
	@InjectMocks
	private EmployeeService empServ = new EmployeeServiceImpl();


	@BeforeAll // Filling or creating the Mock 
	public static void mockSetupEmployee() {
		
		mockEmployee = new HashSet <> ();// Create the mock		
		Employee employee = new Employee();		
		for (int i=1; i<=5; i++) { 
			employee.setEmpId(i);
			if (i < 3) employee.setEmpId(i);
			mockEmployee.add(employee);
		}
		
	}// End of mockSetup

	@BeforeAll
	public static void mockSetupReimbursement() {
		
		mockReimbursement = new HashSet<> (); // Create the Mock
		Reimbursement reimbursement = new Reimbursement();
		for (int i=1; i<=5; i++) { 
			reimbursement.setReqId(i); 
			if (i<3) reimbursement.setReqId(i);
			mockReimbursement.add(reimbursement);

		}// End of Filling up the Mock
	}// End of mockSetup
	
	
////////////////////////////////////////////////////////////////////////
	

	@Test
	public void submitNewReimbursementSuccessfully() {
		Reimbursement reim = new Reimbursement();

		when(reimDao.create(reim)).thenReturn(10);

		int newId = empServ.submitReimbursementRequest(reim);

		assertNotEquals(0, newId);
	}

	@Test
	public void submitNewReimbursementSomethingWrong() {
		Reimbursement reim = new Reimbursement();

		when(reimDao.create(reim)).thenReturn(0);

		int newId = empServ.submitReimbursementRequest(reim);

		assertEquals(0,newId);
	}	


	////////////////////////////////////////////////////////////////////////	


	@Test
	public void getByIdEmployeeExists() {
		Employee emp = new Employee();
		emp.setEmpId(2);

		when(empDao.getById(2)).thenReturn(emp);

		Employee actualEmp = empServ.getEmployeeById(2);
		assertEquals(emp, actualEmp);
	}

	@Test
	public void getByIdEmployeeDoesNotExist() {

		when(empDao.getById(2)).thenReturn(null);

		Employee actualEmp = empServ.getEmployeeById(2);
		assertNull(actualEmp);
	}


	//////////////////////////////////////////////////////////////////////


	@Test
	public void addNewCommentSuccessfully() {
		Comment cmt = new Comment();

		when(cmtDao.create(cmt)).thenReturn(10);

		int newId = empServ.addComment(cmt);

		assertNotEquals(0, newId);
	}

	@Test
	public void addNewCommentSomethingWrong() {
		//Employee emp = new Employee();
		Comment cmt = new Comment();

		when(cmtDao.create(cmt)).thenReturn(0);

		int newId = empServ.addComment(cmt);

		assertEquals(0,newId);
	}


	////////////////////////////////////////////////////////


	@SuppressWarnings("unchecked")
	@Test 
	public void getReimbursementRequestsExists() {
		Employee e = new Employee();
		e.setEmpId(1);
		
		when(reimDao.getByRequestor(e)).thenReturn((Set<Reimbursement>) mockReimbursement.iterator().next()); 
		//(Set<Reimbursement>) mockReimbursement.iterator().next()		or 			e

		Set<Reimbursement> actualReimbursement = empServ.getReimbursementRequests(e);

		assertEquals(e, actualReimbursement);
	}

	@Test 
	public void getReimbursementRequestsDoesNotExist() {
		Employee e = new Employee();
		//e.setEmpId(1);
		
		when(reimDao.getByRequestor(e)).thenReturn(Collections.emptySet());

		Set<Reimbursement> actualReimbursement = empServ.getReimbursementRequests(null);

		//assertEquals(e, actualReimbursement);
		assertNull(actualReimbursement);
	}
	// (Employee) Collections.emptySet()

}// End of Class


//@Test
//public void updateSomethingWrong() {
//	Employee mockEmployee = new Employee();
//	mockEmployee.setEmpId(1);
//	
//	doNothing().when(empDao).update(Mockito.any(Employee.class));
//	when(empDao.getById(1)).thenReturn(mockEmployee);
//	
//	Employee emply = new Employee();
//	emply.setEmpId(1);
//	emply.setUsername("qwertyuiop");
//	Employee updatedEmp = empServ.???(emply);
//	assertNotEquals(emply, updatedEmp);
//}

/*
 * @BeforeAll // Filling or creating the Mock 
 * public static void mockSetup() {
 * mockEmployee = new HashSet <> ();// Create the mock
 * 
 * for (int i=1; i<=5; i++) { Employee employee = new Employee();
 * employee.setEmpId(i); 
 * if (i<3) employee.setFirstName("Bruce");
 * mockEmployee.add(employee); }// End of Filling up the Mock
 * 
 * }// End of mockSetup
 */


