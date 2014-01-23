/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.User;

import java.util.Date;
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

//@Ignore("Test not ready yet")
public class UserJDBCTemplateTest {
	
	private EmbeddedDatabase db;
	private DataSource dataSource;
        private UserJDBCTemplate jdbc = new UserJDBCTemplate();
	

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
	 * Test of setDataSource method, of class UserJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
		
	}

	/**
	 * Test of getUser method, of class UserJDBCTemplate.
	 */
	@Test
	public void testGetUser() {
		
	}

	/**
	 * Test of listUsers method, of class UserJDBCTemplate.
	 */
	@Test
	public void testListUsers() {
		
	}

	/**
	 * Test of setPassword method, of class UserJDBCTemplate.
	 */
	@Test
	public void testSetPassword() {
		
	}

	/**
	 * Test of updateUser method, of class UserJDBCTemplate.
	 */
	@Test
	public void testUpdateUser() {
		
	}

	/**
	 * Test of getUserByEmail method, of class UserJDBCTemplate.
	 */
	@Test
	public void testGetUserByEmail() {
		
	}

	/**
	 * Test of create method, of class UserJDBCTemplate.
	 */
	@Test
	public void testCreate() {
		User user = new User();
                user.setDate(new Date());
                user.setEmail("tkolsen@stud.no");
                user.setFirstName("Tom");
                user.setLastName("Olsen");
                user.setEnabled(1);
                user.setPassword("123");
                
                System.out.println("User: " + user.toString());
                jdbc.create(user);
                
                User test = jdbc.getUserByEmail("tkolsen@stud.no");
                System.out.println("Test user: " + test.toString());
                assertEquals(user, test);
	}
}