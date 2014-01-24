
package org.teamone.domain.Subject;

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
public class SubjectJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private SubjectJDBCTemplate jdbc = new SubjectJDBCTemplate();

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
	 * Test of setDataSource method, of class SubjectJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
	}

	/**
	 * Test of getSubject method, of class SubjectJDBCTemplate.
	 */
	@Test
	public void testGetSubject() {
	}

	/**
	 * Test of listSubjects method, of class SubjectJDBCTemplate.
	 */
	@Test
	public void testListSubjects() {
	}

	/**
	 * Test of setStatus method, of class SubjectJDBCTemplate.
	 */
	@Test
	public void testSetStatus() {
	}
}