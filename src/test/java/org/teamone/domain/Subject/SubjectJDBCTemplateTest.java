/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.Subject;

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
public class SubjectJDBCTemplateTest {
	
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
}