/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.UserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserTaskMapper implements RowMapper<UserTask> {

    @Override
    public UserTask mapRow(ResultSet rs, int i) throws SQLException {
        UserTask userTasks = new UserTask();
        userTasks.setEmail(rs.getString("email"));
        userTasks.setSubjectCode(rs.getString("subject_code"));
        userTasks.setTaskNr(rs.getInt("task_nr"));
        return userTasks;
    }
}
