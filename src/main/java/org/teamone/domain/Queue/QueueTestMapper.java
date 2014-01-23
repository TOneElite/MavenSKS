/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.teamone.domain.Queue;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ida
 */
public class QueueTestMapper implements RowMapper<Queue>{

    @Override
    public Queue mapRow(ResultSet rs, int i) throws SQLException {
        Queue queue = new Queue();
        queue.setId(rs.getInt("queue_id"));
        queue.setSubjectCode(rs.getString("subject_code"));
        
        return queue;
    }
    
}
