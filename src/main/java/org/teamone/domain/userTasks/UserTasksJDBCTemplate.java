/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.userTasks;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Ida
 */
public class UserTasksJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    
    public void approve(String email, String subject_code, int task) {
        String SQL = "insert into user_tasks(email, subject_code, task_nr) values(?,?,?)";
    jdbcTemplateObject.update(SQL, email, subject_code, task);
    }
}
