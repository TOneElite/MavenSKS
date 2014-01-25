package org.teamone.domain.User;

import java.util.Date;
import java.util.List;
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
     * Test of listUsers method, of class UserJDBCTemplate.
     */
    @Test
    public void testListUsers() {
        List<User> test = jdbc.listUsers();
        int amontUsers = 5;

        assertFalse(amontUsers != test.size());

        for (int i = 0; i <= test.size(); i++) {
            for (int j = i++; j <= (test.size() - j); j++) {
                assertFalse(test.get(i).equals(test.get(j)));
            }
        }
    }

    /**
     * Test of setPassword method, of class UserJDBCTemplate.
     */
    @Test
    public void testSetPassword() {
        User user = new User();
        user.setEmail("leonardo@ninjaturtle.jap");
        user.setFirstName("Leonardo");
        user.setLastName("DaVinci");
        user.setPassword("ninjatoman");
        user.setPassword("12345");
        user.setEnabled(1);
        user.setDate(new Date("1990-01-02"));

        jdbc.setPassword("leonardo@ninjaturtle.jap", "12345");

        User test = jdbc.getUserByEmail("leonardo@ninjaturtle.jap");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);

    }

    /**
     * Test of updateUser method, of class UserJDBCTemplate.
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setEmail("megaman@rockman.no");
        user.setFirstName("Megaman");
        user.setLastName("Thomasson");
        user.setEnabled(1);
        user.setPassword("motherWhale");
        user.setDate(new Date("2153-01-09"));

        jdbc.updateUser(user);

        User test = jdbc.getUserByEmail("");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
    }

    /**
     * Test of getUserByEmail method, of class UserJDBCTemplate.
     */
    @Test
    public void testGetUserByEmail() {

        User user = new User();
        user.setEmail("leonardo@ninjaturtle.jap");
        user.setFirstName("Leonardo");
        user.setLastName("DaVinci");
        user.setPassword("ninjatoman");
        user.setPassword("12345");
        user.setEnabled(1);
        user.setDate(new Date("1990-01-02"));

        User test = jdbc.getUserByEmail("leonardo@ninjaturtle.jap");
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
        user.setEmail("titsio@boobie.au");
        user.setFirstName("Titty");
        user.setLastName("Boobler");
        user.setEnabled(1);
        user.setPassword("123");

        jdbc.create(user);

        User test = jdbc.getUserByEmail("titsio@boobie.au");
        System.out.println("Test user: " + test.toString());
        assertEquals(user, test);
    }
}
