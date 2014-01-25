package org.teamone.domain.Queue;

import java.sql.Date;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim 
 * This test is almost useless and imcomplete, as it currently heavily relies on a
 * function that is incompatible with the embedded database type in order to
 * assert if methods have successfully made changes to the database.
 */
public class QueueJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private QueueJDBCTemplate jdbc = new QueueJDBCTemplate();

	@Before
	public void setUp() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();
		dataSource = db;
		jdbc.setDataSource(dataSource);
	}

	@After
	public void tearDown() {
		db.shutdown();
	}

	/*
	 * The default method for mapping database entries of the queuetable is not 
	 * compatible with the H2-databasetype used as the testing mock database.
	 * This function serves as a replacement, and returns a list of all queue-entries
	 * 
	 * TODO: Implement this function.
	 */
	private ArrayList<Queue> fetchQueueDetails() {
		ArrayList<Queue> queues = new ArrayList();

		return queues;
	}

	/*
	 * Test of getQueue method, of class QueueJDBCTemplate.
	 * The QueueTestMapper used by the getQueue-method only fetches ID and subjectcode.
	 */
	@Test
	public void testGetQueue() {
		String subjectCode = "2ING-2003-14V";
		Queue expected = new Queue();
		expected.setId(1);
		expected.setSubjectCode(subjectCode);
		expected.setComment("Trenger hjelp");
		expected.setStatus("Venter");
		expected.setLocation("Bord 1, rom skvett");
		expected.setDate(new Date(19600101161011L));
		Queue actual = jdbc.getQueue(1);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getSubjectCode(), actual.getSubjectCode());
	}

	/**
	 * Test of listQueue method, of class QueueJDBCTemplate.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, cannot be tested with a H2 database-type.")
	public void testListQueue_String() {
	}

	/**
	 * Test of delete method, of class QueueJDBCTemplate. TODO: Update to
	 * replace the jdbc.listQueue() function with the fetchQueueDetails() method
	 * when it is implemented.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, statements used when retrieving details cannot be tested with a H2 database-type.")
	public void testDelete() {
		int beforeDelete = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(1, beforeDelete);
		jdbc.delete(1);
		int afterDelete = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(0, afterDelete);
	}

	/*
	 * Test of empty method, of class QueueJDBCTemplate.
	 * TODO: Update to replace the jdbc.listQueue() function with 
	 * the fetchQueueDetails() method when it is implemented.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, statements used when retrieving details cannot be tested with a H2 database-type.")
	public void testEmpty() {
		int beforeEmpty = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(1, beforeEmpty);
		jdbc.empty("2ING-2003-14V");
		int afterEmpty = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(0, afterEmpty);
	}

	/**
	 * Test of update method, of class QueueJDBCTemplate. TODO: Write test
	 * later, function not implemented yet.
	 */
	@Test
	@Ignore("Function to be tested not implemented")
	public void testUpdate() {
	}

	/**
	 * Test of status method, of class QueueJDBCTemplate.
	 */
	@Test
	@Ignore("getQueue() only retrieves id and subject code, and must be replaced.")
	public void testStatus() {
		String beforeStatusChange = jdbc.getQueue(1).getStatus();
		assertEquals("Venter", beforeStatusChange);
		jdbc.status("Utsatt", 1);
		String afterStatusChange = jdbc.getQueue(1).getStatus();
		System.out.println(afterStatusChange);
		assertEquals("Utsatt", afterStatusChange);
	}

	/**
	 * Test of create method, of class QueueJDBCTemplate.
	 * TODO: Some tests implemented, but not complete.
	 */
	@Test
	public void testCreate() {
		Queue expected = new Queue();
		expected.setId(2);
		expected.setSubjectCode("TDAT-1995-12H");
		expected.setComment("halp plx");
		expected.setStatus("Venter");
		expected.setLocation("Bord 2, rom KAUD");
		expected.setDate(new Date(19600101161011L));
		
		QueueGroup group = new QueueGroup();
		int[] tasks = {3};
		String[] users = {"megaman@rockman.no"};
		group.setTaskNrs(tasks);
		group.setUsers(users);
		
		
		jdbc.create(expected, group);
		assertEquals(expected.getId(), jdbc.getQueue(2).getId());
		assertEquals(expected.getUsers(), jdbc.getQueue(2).getUsers());
	}
}