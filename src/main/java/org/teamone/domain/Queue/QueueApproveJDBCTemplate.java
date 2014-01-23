package org.teamone.domain.Queue;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class QueueApproveJDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public List<QueueApprove> listQueueApproveID(int id){
        String SQL = "SELECT * FROM queue_group WHERE queue_id=?";
        List<QueueApprove> list = jdbcTemplateObject.query(SQL, new Object[]{id}, new QueueApproveMapper());
        return list;
    }
    
    

}
