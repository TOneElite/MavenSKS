package org.teamone.domain.ApprovedTasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserTaskMapper implements RowMapper<ApprovedTasks> {

    @Override
    public ApprovedTasks mapRow(ResultSet rs, int i) throws SQLException {
        ApprovedTasks approvedTasks = new ApprovedTasks();
        approvedTasks.setEmail(rs.getString("email"));
        approvedTasks.setSubjectCode(rs.getString("subject_code"));
        approvedTasks.setTaskNr(rs.getInt("task_nr"));
        approvedTasks.setApprovedDate(rs.getDate("approved_date"));
		approvedTasks.setApprovedBy(rs.getString("approved_by"));
        return approvedTasks;
    }
}
