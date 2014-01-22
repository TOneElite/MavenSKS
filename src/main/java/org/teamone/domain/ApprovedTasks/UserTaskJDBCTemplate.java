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

    public void approve(ApprovedTasks userTasks) {
        System.out.println(userTasks.toString());
        String SQL = "insert into user_task(email, subject_code, task_nr, date) values(?,?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            userTasks.getEmail(),
            userTasks.getSubjectCode(),
            userTasks.getTaskNr(),
            userTasks.getDate()});
    }
    
    public List<ApprovedTasks> listApprovedTasks(String email, String subjectCode){
        String SQL = "SELECT * FROM user_task WHERE email='"+email+"' AND subject_code='"+subjectCode+"'";
        List<ApprovedTasks> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    }
    
        public List<ApprovedTasks> listApprovedTasksWithoutSubject(String email){
        String SQL = "SELECT * FROM user_task WHERE email='"+email+"'";
        List<ApprovedTasks> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    }
}
