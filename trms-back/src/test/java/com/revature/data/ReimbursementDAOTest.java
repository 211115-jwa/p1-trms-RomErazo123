package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.postgres.ReimbursementPostgres;

public interface ReimbursementDAOTest {
	ReimbursementDAO reimbursementDao = new ReimbursementPostgres();

	@Test
	public static void createTest() {
		Reimbursement create = new Reimbursement();
		assertNotEquals(0, reimbursementDao.create(create));
		// use reimbursement dao to test that create method is not equal to another reimbursement
	}

	@Test
	public static void getAll() {
		Set<Reimbursement> givenOutput = reimbursementDao.getAll();
		assertNotNull(givenOutput);
		// assertNotNull(ReimbursementDao.getall());
	}

	@Test
	public static void testUpdate() {
		Reimbursement personUp = reimbursementDao.getById(1);
		personUp.setLocation("Work");
		reimbursementDao.update(personUp);
		assertEquals("Work",reimbursementDao.getById(1).getLocation());	
		// use reimbursement dao to test the Update method is equal to record added 
	}

	@Test
	public static void testNotValidId() {
		Reimbursement reimbursementOutput= reimbursementDao.getById(10000);
		assertNull(reimbursementOutput);
		// use reimbursement dao to test that getNotValidId method is null
	}
	
	@Test
	public static void getValidId()
	{
		int reqA = 1;
		Reimbursement actual = reimbursementDao.getById(1);
		assertEquals(reqA, actual.getReqId());
		// use reimbursement dao to test the getValidId method is equal to record that is being search by
	}
	

}// End of Calss
