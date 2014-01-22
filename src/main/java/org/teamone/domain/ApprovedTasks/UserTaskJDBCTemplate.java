package org.teamone.domain.ApprovedTasks;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Ida
 */
public class UserTaskJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void approve(ApprovedTasks approvedTasks) {
        System.out.println(approvedTasks.toString());
        String SQL = "INSERT INTO approved_tasks(email, subject_code, task_nr, approved_date, approved_by) values(?,?,?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            approvedTasks.getEmail(),
            approvedTasks.getSubjectCode(),
            approvedTasks.getTaskNr(),
            approvedTasks.getApprovedDate(),
			approvedTasks.getApprovedBy()
		});
		
    }
    
    public List<ApprovedTasks> listApprovedTasks(String email, String subjectCode){
        String SQL = "SELECT * FROM approved_tasks WHERE email='"+email+"' AND subject_code='"+subjectCode+"'";
        List<ApprovedTasks> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    }
    
        public List<ApprovedTasks> listApprovedTasksWithoutSubject(String email){
        String SQL = "SELECT * FROM approved_tasks WHERE email='"+email+"'";
        List<ApprovedTasks> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    }
}
