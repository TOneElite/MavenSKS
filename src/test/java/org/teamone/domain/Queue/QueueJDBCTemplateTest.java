
package org.teamone.domain.Queue;

import javax.sql.DataSource;
import org.junit.After;
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
@Ignore("Test is a prototype, skip for now")
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

	/**
	 * Test of setDataSource method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
	}

	/**
	 * Test of getQueue method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testGetQueue() {
	}

	/**
	 * Test of listQueue method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testListQueue_0args() {
	}

	/**
	 * Test of listQueue method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testListQueue_String() {
	}

	/**
	 * Test of delete method, of class QueueJDBCTemplate.
	 */
	@Test
	public void testDelete() {
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