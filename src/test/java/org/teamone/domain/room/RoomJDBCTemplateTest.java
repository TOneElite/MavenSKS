
package org.teamone.domain.room;

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
public class RoomJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private RoomJDBCTemplate jdbc = new RoomJDBCTemplate();

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
	 * Test of setDataSource method, of class RoomJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
	}

	/**
	 * Test of getRoom method, of class RoomJDBCTemplate.
	 */
	@Test
	public void testGetRoom() {
	}

	/**
	 * Test of listRoom method, of class RoomJDBCTemplate.
	 */
	@Test
	public void testListRoom() {
	}
}