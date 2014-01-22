package org.teamone.domain.Queue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QueueMapper implements RowMapper<Queue> {
    
    @Override
    public Queue mapRow(ResultSet rs, int i) throws SQLException {
        Queue queue = new Queue();
        queue.setId(rs.getInt("queue_id"));
        queue.setDate(rs.getDate("timestamp"));
        queue.setComment(rs.getString("comment"));
        queue.setStatus(rs.getString("status"));
        queue.setSubjectCode(rs.getString("subject_code"));
		queue.setLocation(rs.getString("location"));
		
		// needs queuegroup mapper
		
        return queue;
    }
    
}