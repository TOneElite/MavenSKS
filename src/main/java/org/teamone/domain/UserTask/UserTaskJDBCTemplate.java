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
        String SQL = "insert into user_subject(email, subject_code, task_nr) values(?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            userTasks.getEmail(),
            userTasks.getSubjectCode(),
            userTasks.getTaskNr()});
    }
    
    /*
    public List<UserTask> getApprovedTasks(String email, String subject_code){
        String SQL = "SELECT task_nr from user_tasks where email=? subject_code=?";
        List<UserTask> tasks = jdbcTemplateObject.query(SQL, new UserTaskMapper());       
        return tasks;
    } */
}
