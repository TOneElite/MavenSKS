
package org.teamone.domain.Role;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim, Tom
 */

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
		jdbc.setDataSource(dataSource);
	}
        
        /**
         * Test of getRoleInSubject method, of class RoleJDBCTemplate.
         */
        @Test
        public void testGetRoleInSubject(){
            List<Role> roles = jdbc.getRoleInSubject("dude@boob.net", "TDAT-1995-12H");
            assertEquals(1, roles.size());
            
            Role testRole = new Role();
            testRole.setEmail("dude@boob.net");
            testRole.setRoleName("ROLE_ADMIN");
            testRole.setSubjectCode("TDAT-1995-12H");
            
            assertEquals(testRole, roles.get(0));
        }
        
        /**
         * Test of getSubjectRolesCon method, of class RoleJDBCTemplate.
         * TODO: Ole må ta denne.
         */
        @Test
        public void testGetSubjectRolesCon(){
            
        }

	/**
	 * Test of getSubjectRoles(String email) method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testGetSubjectRoles() {
		List<Role> roles = jdbc.getSubjectRoles("leonardo@ninjaturtle.jap");
                
                // Check that the size is as expected
                assertEquals(2, roles.size());
                
                for(Role r : roles){
                    // Check that all objects has the right email
                    assertEquals("leonardo@ninjaturtle.jap", r.getEmail());
                    // Check that all objects has the right role
                    assertEquals("ROLE_TEACHER", r.getRoleName());
                }
	}

	/**
	 * Test of create method, of class RoleJDBCTemplate.
	 */
	@Test
	public void testCreate() {
		Role role = new Role();
                role.setEmail("leonardo@ninjaturtle.jap");
                role.setRoleName("ROLE_USER");
                role.setSubjectCode("2ING-2003-14V");
                jdbc.create(role);
                
                List<Role> test = jdbc.getRoleInSubject("leonardo@ninjaturtle.jap", "2ING-2003-14V");
                // Check if the user has the right amount of roles in the subject.
                assertEquals(2, test.size());
                
                // Try to insert with invalid data.
                try{
                    role.setEmail("fail@fail.no");
                    jdbc.create(role);
                    role.setEmail("leonardo@ninjaturtle.jap");
                    role.setRoleName("fail");
                    jdbc.create(role);
                    role.setRoleName("ROLE_USER");
                    role.setSubjectCode("fail");
                    jdbc.create(role);
                    assert(false);
                }catch(Exception e){
                    assert(true);
                }
                
                // Check if the user has USER_ROLE in the subject
                for(Role r : test){
                    if(r.getRoleName().equals("ROLE_USER")){
                        assert(true);
                        return;
                    }
                }
                assert(false);
	}
        
        /**
         * Test of getStudentSubjects method, of class RoleJDBCTemplate.
         */
        @Test
        public void testGetStudentSubjects(){
            String email = "mario@peachcastle.derp";
            String subjectCode1 = "TDAT-1995-12H";
            String subjectCode2 = "2ING-2003-14V";
            
            List<Role> roles = jdbc.getStudentSubjects(email);
            assertEquals(2, roles.size());
            
            boolean role1OK = false;
            boolean role2OK = false;
            
            for(Role r : roles){
                if(r.getSubjectCode().equals(subjectCode1))
                    role1OK = true;
                if(r.getSubjectCode().equals(subjectCode2))
                    role2OK = true;
            }
            
            if(role1OK && role2OK)
                assert(true);
            else
                assert(false);
            
        }
        
        /**
         * Test of getTeacherSubjects method, of class RoleJDBCTemplate.
         */
        @Test
        public void testGetTeacherSubjects(){
            String email = "leonardo@ninjaturtle.jap";
            String subjectCode1 = "TDAT-1995-12H";
            String subjectCode2 = "2ING-2003-14V";
            
            List<Role> roles = jdbc.getTeacherSubjects(email);
            assertEquals(2, roles.size());
            
            boolean role1OK = false;
            boolean role2OK = false;
            
            for(Role r : roles){
                if(r.getSubjectCode().equals(subjectCode1))
                    role1OK = true;
                if(r.getSubjectCode().equals(subjectCode2))
                    role2OK = true;
            }
            
            if(role1OK && role2OK)
                assert(true);
            else
                assert(false);
        }
}