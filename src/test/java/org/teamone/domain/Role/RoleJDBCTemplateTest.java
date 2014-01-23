/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.Role;

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

//@Ignore("Test not ready yet")
public class RoleJDBCTemplateTest {
	
	private EmbeddedDatabase db;
	private DataSource dataSource;
        private RoleJDBCTemplate jdbc = new RoleJDBCTemplate();
	

	@Before
	public void setUp() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();
		dataSource = db;
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
		jdbc.setDataSource(dataSource);
	}

	/**
	 * Test of getRole method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testGetRole() {
		
	}

	/**
	 * Test of create method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testCreate() {
		
	}
}