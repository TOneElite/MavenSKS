
package org.teamone.domain.userRights;

import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
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
@Ignore("Test is a prototype, skip for now")
public class UserRightsJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private UserRightsJDBCTemplate jdbc = new UserRightsJDBCTemplate();

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
	 * Test of setDataSource method, of class UserRightsJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
	}

	/**
	 * Test of getUserRight method, of class UserRightsJDBCTemplate.
	 */
	@Test
	public void testGetUserRight() {
	}
}