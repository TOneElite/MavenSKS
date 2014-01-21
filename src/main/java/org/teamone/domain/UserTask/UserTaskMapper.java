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
        userTasks.setDate(rs.getDate("date"));
        return userTasks;
    }
}
