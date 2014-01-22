package org.teamone.domain.ApprovedTasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserTaskMapper implements RowMapper<ApprovedTasks> {

    @Override
    public ApprovedTasks mapRow(ResultSet rs, int i) throws SQLException {
        ApprovedTasks userTasks = new ApprovedTasks();
        userTasks.setEmail(rs.getString("email"));
        userTasks.setSubjectCode(rs.getString("subject_code"));
        userTasks.setTaskNr(rs.getInt("task_nr"));
        userTasks.setDate(rs.getDate("date"));
        return userTasks;
    }
}
