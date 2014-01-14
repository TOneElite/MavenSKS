package org.teamone.domain;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class QueueJDBCTemplate {
    
    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public Queue getQueue(int ID){
        String SQL = "select * from queue where queue_id = ?";
        Queue queue = (Queue)jdbcTemplateObject.queryForObject(SQL, new Object[]{ID}, new QueueMapper());
        return queue;
    }
    
    public List<Queue> listQueue(){
        String SQL = "SELECT * FROM queue";
        List<Queue> queues = jdbcTemplateObject.query(SQL, new QueueMapper());
        return queues;
    }

    public void delete(int id) {
        String SQL = "delete from queue where queue_id = ?";
        jdbcTemplateObject.update(SQL, id);
    }
    
    public void update(Queue queue){
        String SQL = "update queue set user=?, tasks=?, comment=?, location=? where queue_id=?";
        jdbcTemplateObject.update(SQL, new Object[]{
            queue.getUsers(),
            queue.getOv(),
            queue.getComment(),
            queue.getTables(),
            queue.getId(),
        });
    }
    
    public void create(Queue queue){
        String SQL = "insert into queue(time, user, tasks, comment, status, location) values(?,?,?,?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{queue.getDate(), queue.getUsers(), queue.getOv(), queue.getComment(), queue.getStatus(), queue.getTables()});
    }
    
}
