package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;

import com.revature.data.postgres.EmployeePostgres;

public interface EmployeeDAOTest {
	EmployeeDAO employeeDao = new EmployeePostgres();

	@Test
	public static void createTest() {
		Employee create = new Employee();
		assertNotEquals(0, employeeDao.create(create));
		// use employee dao to test that create method is not equal to another employee
	}

	@Test
	public static void testNotValidId() {
		Employee employeeOutput= employeeDao.getById(10000);
		assertNull(employeeOutput);
		// use employee dao to test that getNotValidId method is null
	}
	
	@Test
	public static void testUpdate() {
		Employee personUp = employeeDao.getById(1);
		personUp.setFirstName("Boss");
		employeeDao.update(personUp);
		assertEquals("Boss",employeeDao.getById(1).getFirstName());	
		// use employee dao to test the Update method is equal to record added 
	}
	
	@Test
	public static void getValidPersonById()
	{
		String expectedUsername = "BruWill123";
		Employee actual = employeeDao.getById(1);
		assertEquals(expectedUsername, actual.getUsername());
		// use employee dao to test the getValidId method is equal to record that is being search by
	}
	
	@Test
	public static void getByUsernameWhenUsernameExists() {
		// setup
		String usernameInput = "BruWill123";
		// call the method we're testing
		Employee employeeOutput = employeeDao.getByUsername(usernameInput);
		// assert that it did what we expected
		assertEquals("BruWill123", employeeOutput.getUsername());
		// use employee dao to test the getByUsernameWhenUsernameExists method is equal 
		// to the username that exists
	}
	
	@Test
	public static void getByUsernameButUsernameDoesNotExist() {
		String usernameInput = "qwertyuiop";
		Employee employeeOutput = employeeDao.getByUsername(usernameInput);
		assertNull(employeeOutput); // assertEquals(null, employeeOutput)
		// use employee dao to test the getByUsernameWhenUsernameDoesNotExist method is null 
		// because the username does not exists
	}
	
	@Test
	public static void getAll() {
		Set<Employee> givenOutput = employeeDao.getAll();
		assertNotNull(givenOutput);
		// assertNotNull(employeeDao.getall());
	}

}// End of Class
