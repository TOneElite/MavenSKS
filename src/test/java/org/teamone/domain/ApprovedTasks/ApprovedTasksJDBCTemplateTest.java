package org.teamone.domain.ApprovedTasks;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 *
 * @author Kim
 */

public class ApprovedTasksJDBCTemplateTest {

	private EmbeddedDatabase db;
	private DataSource dataSource;
	private ApprovedTasksJDBCTemplate jdbc = new ApprovedTasksJDBCTemplate();

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
	 * Test of approve method, of class ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testApprove() {
		ApprovedTasks task = new ApprovedTasks();
		task.setEmail("megaman@rockman.no");
		task.setSubjectCode("2ING-2003-14V");
		task.setTaskNr(10);
		task.setApprovedBy("leonardo@ninjaturtle.jap");
		task.setApprovedDate(new Date());
		
		jdbc.approve(task);
		
		String userEmail = "megaman@rockman.no";
		String subjectCode = "2ING-2003-14V";
		List<ApprovedTasks> tasks = jdbc.listApprovedTasks(userEmail, subjectCode);
		
		assertTrue(5 == tasks.size());

		for (int i = 0; i < tasks.size(); i++) {
			assertEquals(tasks.get(i).getEmail(), userEmail);
			assertEquals(tasks.get(i).getSubjectCode(), subjectCode);
			assertEquals(tasks.get(i).getApprovedBy(), "leonardo@ninjaturtle.jap");
		}

		assertEquals(tasks.get(0).getTaskNr(), 1);
		assertEquals(tasks.get(1).getTaskNr(), 2);
		assertEquals(tasks.get(2).getTaskNr(), 4);
		assertEquals(tasks.get(3).getTaskNr(), 6);
		assertEquals(tasks.get(4).getTaskNr(), 10);
	}

	/**
	 * Test of listApprovedTasks method, of class ApprovedTasksJDBCTemplate. NB:
	 * The date values are not tested for.
	 */
	@Test
	public void testListApprovedTasks() {
		String userEmail = "megaman@rockman.no";
		String subjectCode = "2ING-2003-14V";
		List<ApprovedTasks> tasks = jdbc.listApprovedTasks(userEmail, subjectCode);

		assertTrue(4 == tasks.size());

		for (int i = 0; i < tasks.size(); i++) {
			assertEquals(tasks.get(i).getEmail(), userEmail);
			assertEquals(tasks.get(i).getSubjectCode(), subjectCode);
			assertEquals(tasks.get(i).getApprovedBy(), "leonardo@ninjaturtle.jap");
		}

		assertEquals(tasks.get(0).getTaskNr(), 1);
		assertEquals(tasks.get(1).getTaskNr(), 2);
		assertEquals(tasks.get(2).getTaskNr(), 4);
		assertEquals(tasks.get(3).getTaskNr(), 6);
	}

	/**
	 * Test of listApprovedTasksWithoutSubject method, of class
	 * ApprovedTasksJDBCTemplate.
	 */
	@Test
	public void testListApprovedTasksWithoutSubject() {
		String userEmail = "megaman@rockman.no";
		String subjectCode1 = "2ING-2003-14V";
		String subjectCode2 = "TDAT-1995-12H";
		List<ApprovedTasks> tasks = jdbc.listApprovedTasksWithoutSubject(userEmail);

		assertTrue(5 == tasks.size());

		for (int i = 0; i < tasks.size(); i++) {
			if (i <= 3) {
				assertEquals(tasks.get(i).getEmail(), userEmail);
				assertEquals(tasks.get(i).getSubjectCode(), subjectCode1);
				assertEquals(tasks.get(i).getApprovedBy(), "leonardo@ninjaturtle.jap");
			}else{
				assertEquals(tasks.get(i).getEmail(), userEmail);
				assertEquals(tasks.get(i).getSubjectCode(), subjectCode2);
				assertEquals(tasks.get(i).getApprovedBy(), "leonardo@ninjaturtle.jap");
			}
		}
		assertEquals(tasks.get(0).getTaskNr(), 1);
		assertEquals(tasks.get(1).getTaskNr(), 2);
		assertEquals(tasks.get(2).getTaskNr(), 4);
		assertEquals(tasks.get(3).getTaskNr(), 6);
		assertEquals(tasks.get(4).getTaskNr(), 9);
	}
}