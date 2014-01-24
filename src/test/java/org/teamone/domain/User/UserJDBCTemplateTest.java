package org.teamone.domain.User;

import java.util.Date;
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
        User user = new User();
        user.setEmail("oosen@stud.no");
        user.setFirstName("Ole");
        user.setLastName("Olsen");
        user.setEnabled(1);
        user.setPassword("123");
        
        System.out.println("User: " + user.toString());
        jdbc.create(user);
        
        jdbc.setPassword("oosen@stud.no", "12345");
        
        user.setPassword("12345");
        
        User test = jdbc.getUserByEmail("oosen@stud.no");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
              
    }

    /**
     * Test of updateUser method, of class UserJDBCTemplate.
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setEmail("ohuseby@stud.no");
        user.setFirstName("Oystein");
        user.setLastName("Huseby");
        user.setEnabled(1);
        user.setPassword("123");

        System.out.println("User: " + user.toString());
        jdbc.create(user);

        jdbc.updateUser(user);
        
        user.setFirstName("Øystein");

        User test = jdbc.getUserByEmail("ohuseby@stud.no");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
    }

    /**
     * Test of getUserByEmail method, of class UserJDBCTemplate.
     */
    @Test
    public void testGetUserByEmail() {
        
        User user = new User();
        user.setEmail("tolsen@stud.no");
        user.setFirstName("Tom");
        user.setLastName("Olsen");
        user.setEnabled(1);
        user.setPassword("123");
        
        jdbc.create(user);
        
        User test = jdbc.getUserByEmail("tolsen@stud.no");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
    }

    /**
     * Test of create method, of class UserJDBCTemplate.
     */
    @Test
    public void testCreate() {
        User user = new User();
        user.setDate(new Date());
        user.setEmail("pard@stud.no");
        user.setFirstName("PerI");
        user.setLastName("Ard");
        user.setEnabled(1);
        user.setPassword("123");

        System.out.println("User: " + user.toString());
        jdbc.create(user);

        User test = jdbc.getUserByEmail("pard@stud.no");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
    }
}
