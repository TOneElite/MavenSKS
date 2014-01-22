package org.teamone.domain.Queue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QueueMapper implements RowMapper<Queue> {
    
    @Override
    public Queue mapRow(ResultSet rs, int i) throws SQLException {
        Queue queue = new Queue();
        
        queue.setId(rs.getInt("queue_id"));
        queue.setSubjectCode(rs.getString("subject_code"));
        queue.setTasks(rs.getString("tasks"));
        queue.setComment(rs.getString("comment"));
        queue.setStatus(rs.getString("status"));
        queue.setDate(rs.getDate("timestamp"));
        queue.setLocation(rs.getString("location"));
        queue.setFirstNames(rs.getString("name"));
        queue.setUsers(rs.getString("email"));
		
        return queue;
    }
    
}