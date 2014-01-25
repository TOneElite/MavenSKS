
package org.teamone.domain.Role;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import static org.junit.Assert.*;
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
public class RoleNameJDBCTemplateTest {
	
	private EmbeddedDatabase db;
	private DataSource dataSource;
	private RoleNameJDBCTemplate jdbc = new RoleNameJDBCTemplate();

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
	 * Test of setDataSource method, of class RoleNameJDBCTemplate.
	 */
	@Test
	public void testSetDataSource() {
		jdbc.setDataSource(dataSource);
	}

	/**
	 * Test of listRoleName method, of class RoleNameJDBCTemplate.
	 */
	@Test
	public void testListRoleName() {
		List<RoleName> roleNames = jdbc.listRoleName();
                assertEquals(4, roleNames.size());
                
                boolean ok1 = false;
                boolean ok2 = false;
                boolean ok3 = false;
                boolean ok4 = false;
                
                for(RoleName r : roleNames){
                    if(r.getRoleName().equals("ROLE_ADMIN"))
                        ok1 = true;
                    if(r.getRoleName().equals("ROLE_USER"))
                        ok2 = true;
                    if(r.getRoleName().equals("ROLE_TEACHER"))
                        ok3 = true;
                    if(r.getRoleName().equals("ROLE_STUDASS"))
                        ok4 = true;
                }
                
                if(ok1 && ok2 && ok3 && ok4)
                    assert(true);
                else
                    assert(false);
	}
}