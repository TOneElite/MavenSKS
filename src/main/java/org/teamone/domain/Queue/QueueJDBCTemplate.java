package org.teamone.domain.Queue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class QueueJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

	public Queue getQueue(int ID) {
		String SQL = "SELECT * FROM queue WHERE queue_id = ?";
		Queue queue = (Queue) jdbcTemplateObject.queryForObject(SQL, new Object[]{ID}, new QueueTestMapper());
		return queue;
	}

    /*
     * TODO: Review if the function is necessary
     */
    public List<Queue> listQueue() {
        String SQL = "SELECT * FROM queue";
        List<Queue> queues = jdbcTemplateObject.query(SQL, new QueueMapper());
        return queues;
    }

    // Returns all queueposts with the given subjectCode
    public List<Queue> listQueue(String subjectCode) {
        /*
         SELECT queue.*, 
         group_concat(DISTINCT queue_group.email SEPARATOR ', ') as email, 
         group_concat(DISTINCT(CONVERT(queue_group.task_nr, CHAR(2))) SEPARATOR ', ') as tasks, 
         group_concat(DISTINCT users.firstname SEPARATOR ', ') as name
         FROM queue
         NATURAL JOIN queue_group
         NATURAL JOIN users
         GROUP by
         queue_group.queue_id;
         */
        String SQL = "SELECT queue.*,"
                + "                    group_concat(DISTINCT queue_group.email SEPARATOR ', ') as email,"
                + "                    group_concat(DISTINCT(CONVERT(queue_group.task_nr, CHAR(2))) SEPARATOR ', ') as tasks,"
                + "                    group_concat(DISTINCT users.firstname SEPARATOR ', ') as name"
                + "                   FROM queue"
                + "                    NATURAL JOIN queue_group"
                + "                    NATURAL JOIN users"
                + "                    WHERE subject_code=?"
                + "                   GROUP by"
                + "                    queue_group.queue_id";
        // Hent queueView
        List<Queue> queues = jdbcTemplateObject.query(SQL, new Object[]{subjectCode}, new QueueMapper());
        return queues;
    }

    public void delete(int id) {
        String SQL = "DELETE FROM queue WHERE queue_id = ?";
        jdbcTemplateObject.update(SQL, id);
    }

    /*
     * TODO: Currently not functioning, SQL must be reviewed to include queue_group
     */
    public void update(Queue queue) {
        String SQL = "UPDATE queue SET user=?, tasks=?, comment=?, location=? WHERE queue_id=?";
        jdbcTemplateObject.update(SQL, new Object[]{queue});
    }

    public void status(String status, int id) {
        String SQL = "UPDATE queue SET status=? WHERE queue_id=?";
        jdbcTemplateObject.update(SQL, status, id);
    }

    /*
     * TODO: implement transaction handling to create group, see comments in function
     */
    private int createReturnID(final Queue queue) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateObject.update(
                new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps =
                        connection.prepareStatement("INSERT INTO queue(timestamp, comment, status, location, subject_code) VALUES(?,?,?,?,?)", new String[]{"timestamp", "comment", "status", "location", "subject_code"});
                ps.setDate(1, queue.getDate());
                ps.setString(2, queue.getComment());
                ps.setString(3, queue.getStatus());
                ps.setString(4, queue.getLocation());
                ps.setString(5, queue.getSubjectCode());
                return ps;
            }
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public void create(Queue queue, QueueGroup group) {
        System.out.println(queue.toString());
        int id = createReturnID(queue);
        System.out.println(id);
        for (String groupMember : group.getUsers()) {
            for (int i : group.getTaskNrs()) {
                String SQL2 = "INSERT INTO queue_group(queue_id, email, task_nr) VALUES (?,?,?)";
                jdbcTemplateObject.update(SQL2, new Object[]{
                    id,
                    groupMember,
                    i
                });
            }
        }



    }
}
