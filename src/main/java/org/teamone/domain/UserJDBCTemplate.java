package org.teamone.domain;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public User getUser(int userID) {
        String SQL = "SELECT * FROM user WHERE user_id=?";
        User user = (User) jdbcTemplateObject.queryForObject(SQL, new Object[]{userID}, new UserMapper());
        return user;
    }

    public List<User> listUsers() {
        String SQL = "SELECT * FROM user";
        List<User> user = jdbcTemplateObject.query(SQL, new UserMapper());
        return user;
    }
}