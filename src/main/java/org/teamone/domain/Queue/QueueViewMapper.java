package org.teamone.domain.Queue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QueueViewMapper implements RowMapper<QueueView> {

    @Override
    public QueueView mapRow(ResultSet rs, int i) throws SQLException {
        QueueView queueView = new QueueView();
        
        queueView.setQueueId(rs.getInt("queue_id"));
        queueView.setSubjectCode(rs.getString("subject_code"));
        queueView.setComment(rs.getString("comment"));
        queueView.setStatus(rs.getString("status"));
        queueView.setLocation(rs.getString("location"));
        queueView.setTimestamp(rs.getDate("timestamp"));
        queueView.setEmail(rs.getString("email"));
        queueView.setTaksNr(rs.getInt("task_nr"));
        
        return queueView;
    }
    
}
