
package org.teamone.domain.Queue;

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
 * @author Kim
 */

public class QueueApproveJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private QueueApproveJDBCTemplate jdbc = new QueueApproveJDBCTemplate();

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
	 * Test of listQueueApproveID method, of class QueueApproveJDBCTemplate.
         * Not sure why, but the listQueueApproveID method pulls the 
	 */
	@Test
	public void testListQueueApproveID() {
            
            List<QueueApprove> group = jdbc.listQueueApproveID(1);
            
            assertEquals(group.get(0).getEmail(), "donatello@ninjaturtle.jap");
            assertEquals(group.get(0).getTaskNr(), 10);
            assertEquals(group.get(0).getQueueId(), 1);
            
            assertEquals(group.get(1).getEmail(), "megaman@rockman.no");
            assertEquals(group.get(1).getTaskNr(), 10);
            assertEquals(group.get(1).getQueueId(), 1);
	}
}