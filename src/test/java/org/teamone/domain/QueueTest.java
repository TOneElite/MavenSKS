/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim
 */
public class QueueTest {
	
	public QueueTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of getId method, of class Queue.
	 */
	@Test
	public void testGetId() {
		System.out.println("getId");
		Queue instance = new Queue();
		int expResult = 0;
		int result = instance.getId();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setId method, of class Queue.
	 */
	@Test
	public void testSetId() {
		System.out.println("setId");
		int id = 0;
		Queue instance = new Queue();
		instance.setId(id);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getUsers method, of class Queue.
	 */
	@Test
	public void testGetUsers() {
		System.out.println("getUsers");
		Queue instance = new Queue();
		String expResult = "";
		String result = instance.getUsers();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setUsers method, of class Queue.
	 */
	@Test
	public void testSetUsers() {
		System.out.println("setUsers");
		String users = "";
		Queue instance = new Queue();
		instance.setUsers(users);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getOv method, of class Queue.
	 */
	@Test
	public void testGetOv() {
		System.out.println("getOv");
		Queue instance = new Queue();
		String expResult = "";
		String result = instance.getOv();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setOv method, of class Queue.
	 */
	@Test
	public void testSetOv() {
		System.out.println("setOv");
		String ov = "";
		Queue instance = new Queue();
		instance.setOv(ov);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getComment method, of class Queue.
	 */
	@Test
	public void testGetComment() {
		System.out.println("getComment");
		Queue instance = new Queue();
		String expResult = "";
		String result = instance.getComment();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setComment method, of class Queue.
	 */
	@Test
	public void testSetComment() {
		System.out.println("setComment");
		String comment = "";
		Queue instance = new Queue();
		instance.setComment(comment);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getStatus method, of class Queue.
	 */
	@Test
	public void testGetStatus() {
		System.out.println("getStatus");
		Queue instance = new Queue();
		String expResult = "";
		String result = instance.getStatus();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setStatus method, of class Queue.
	 */
	@Test
	public void testSetStatus() {
		System.out.println("setStatus");
		String status = "";
		Queue instance = new Queue();
		instance.setStatus(status);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getTables method, of class Queue.
	 */
	@Test
	public void testGetTables() {
		System.out.println("getTables");
		Queue instance = new Queue();
		String expResult = "";
		String result = instance.getTables();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setTables method, of class Queue.
	 */
	@Test
	public void testSetTables() {
		System.out.println("setTables");
		String tables = "";
		Queue instance = new Queue();
		instance.setTables(tables);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDate method, of class Queue.
	 */
	@Test
	public void testGetDate() {
		System.out.println("getDate");
		Queue instance = new Queue();
		Date expResult = null;
		Date result = instance.getDate();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}