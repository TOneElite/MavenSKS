package org.teamone.domain.Queue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class QueueApproveMapper implements RowMapper<QueueApprove>{

    @Override
    public QueueApprove mapRow(ResultSet rs, int i) throws SQLException {
        QueueApprove row = new QueueApprove();
        
        row.setQueueId(rs.getInt("queue_id"));
        row.setEmail(rs.getString("email"));
        row.setTaskNr(rs.getInt("task_nr"));
        
        return row;
    }
    
}
