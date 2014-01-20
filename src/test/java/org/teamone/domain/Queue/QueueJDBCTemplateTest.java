/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.Queue;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim
 */

@Ignore("Test not ready yet")
public class QueueJDBCTemplateTest {
	
	private EmbeddedDatabase db;
	private DataSource dataSource;
	

	@Before
	public void setUp() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder.setType(EmbeddedDatabaseType.DERBY).addScript("schema.sql").addScript("data.sql").build();
		dataSource = db;
	}
	
	@After
	public void tearDown() {
		db.shutdown();
	}

	/**
	 * Test of setDataSource method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
		System.out.println("testSetDataSource()");
		QueueJDBCTemplate instance = new QueueJDBCTemplate();
		instance.setDataSource(dataSource);
	}
//
//	/**
//	 * Test of getQueue method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testGetQueue() {
//		System.out.println("getQueue");
//		int ID = 0;
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		Queue expResult = null;
//		Queue result = instance.getQueue(ID);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of listQueue method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testListQueue() {
//		System.out.println("listQueue");
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		List expResult = null;
//		List result = instance.listQueue();
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of delete method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testDelete() {
//		System.out.println("delete");
//		int id = 0;
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		instance.delete(id);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of update method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testUpdate() {
//		System.out.println("update");
//		Queue queue = null;
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		instance.update(queue);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of status method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testStatus() {
//		System.out.println("status");
//		int status = 0;
//		int id = 0;
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		instance.status(status, id);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of create method, of class QueueJDBCTemplate.
//	 */
//	@Test
//	public void testCreate() {
//		System.out.println("create");
//		Queue queue = null;
//		QueueJDBCTemplate instance = new QueueJDBCTemplate();
//		instance.create(queue);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
}