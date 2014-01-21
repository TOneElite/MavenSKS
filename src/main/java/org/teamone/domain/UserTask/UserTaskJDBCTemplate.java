package org.teamone.domain.UserTask;

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

    public void approve(UserTask userTasks) {
        System.out.println(userTasks.toString());
        String SQL = "insert into user_task(email, subject_code, task_nr, date) values(?,?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            userTasks.getEmail(),
            userTasks.getSubjectCode(),
            userTasks.getTaskNr(),
            userTasks.getDate()});
    }
    
    public List<UserTask> getApprovedTasks(String email){
        String SQL = "SELECT * FROM user_task WHERE email='?'";
        List<UserTask> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    }
}
