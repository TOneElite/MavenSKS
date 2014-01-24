
package org.teamone.domain.ApprovedTasks;

import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim
 */
//@Ignore("Test is a prototype, skip for now")
public class ApprovedTasksJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private ApprovedTasksJDBCTemplate jdbc = new ApprovedTasksJDBCTemplate();

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
	 * Test of setDataSource method, of class ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
	}

	/**
	 * Test of approve method, of class ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testApprove() {
	}

	/**
	 * Test of listApprovedTasks method, of class ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testListApprovedTasks() {
	}

	/**
	 * Test of listApprovedTasksWithoutSubject method, of class
	 * ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testListApprovedTasksWithoutSubject() {
	}
}