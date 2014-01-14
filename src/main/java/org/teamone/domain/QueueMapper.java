/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QueueMapper implements RowMapper<Queue> {
    
    @Override
    public Queue mapRow(ResultSet rs, int i) throws SQLException {
        Queue queue = new Queue();
        queue.setId(rs.getInt("queue_id"));
        queue.setUsers(rs.getString("user"));
        queue.setDate(rs.getDate("timestamp"));
        queue.setOv(rs.getString("tasks"));
        queue.setComment(rs.getString("comment"));
        queue.setStatus(rs.getInt("status"));
        queue.setTables(rs.getString("location"));
        return queue;
    }
    
}