package org.teamone.domain.UserTask;

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
        String SQL = "insert into user_tasks(email, subject_code, task_nr) values(?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            userTasks.getEmail(),
            userTasks.getSubjectCode(),
            userTasks.getTaskNr()});
    }
}
