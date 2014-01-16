/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.userTasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ida
 */
public class UserTasksMapper implements RowMapper<UserTasks> {

    @Override
    public UserTasks mapRow(ResultSet rs, int i) throws SQLException {
        UserTasks userTask = new UserTasks();

        userTask.setEmail(rs.getString("email"));
        userTask.setSubjectCode(rs.getString("subject_code"));
        userTask.setTaskNr(rs.getInt("task_nr"));
        return userTask;
    }
}
