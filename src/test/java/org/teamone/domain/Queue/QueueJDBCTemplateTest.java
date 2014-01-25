package org.teamone.domain.Queue;

import java.sql.Date;
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

	@Test
	/*
	 * Test of getQueue method, of class QueueJDBCTemplate.
	 * The QueueTestMapper used by the getQueue-method only fetches ID and subjectcode.
	 */
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
	@Ignore("Test currently not necessary, function is never used.")
	public void testListQueue_0args() {
	}

	/**
	 * Test of listQueue method, of class QueueJDBCTemplate.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, cannot be tested with a H2 database-type.")
	public void testListQueue_String() {
	}

	/**
	 * Test of delete method, of class QueueJDBCTemplate.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, statements used cannot be tested with a H2 database-type.")
	public void testDelete() {
		int beforeDelete = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(1, beforeDelete);
		jdbc.delete(1);
		int afterDelete = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(0, afterDelete);
	}

	/*
	 * Test of empty method, of class QueueJDBCTemplate.
	 */
	@Test
	@Ignore("Incompatible SQL-database type, statements used cannot be tested with a H2 database-type.")
	public void testEmpty() {
		int beforeEmpty = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(1, beforeEmpty);
		jdbc.empty("2ING-2003-14V");
		int afterEmpty = jdbc.listQueue("2ING-2003-14V").size();
		assertEquals(0, afterEmpty);
	}

	/**
	 * Test of update method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testUpdate() {
	}

	/**
	 * Test of status method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testStatus() {
	}

	/**
	 * Test of create method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testCreate() {
	}
}