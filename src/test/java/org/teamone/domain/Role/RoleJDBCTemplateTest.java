
package org.teamone.domain.Role;

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
@Ignore("Test is a prototype, skip for now")
public class RoleJDBCTemplateTest {
	
	private EmbeddedDatabase db;
	private DataSource dataSource;
	private RoleJDBCTemplate jdbc = new RoleJDBCTemplate();

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
	 * Test of setDataSource method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
		
	}

	/**
	 * Test of getSubjectRoles method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testGetSubjectRoles() {
		
	}

	/**
	 * Test of create method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testCreate() {
		
	}
}