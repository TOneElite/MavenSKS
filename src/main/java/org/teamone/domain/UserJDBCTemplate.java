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
    
    public boolean setPassword(String password, String email){
        String SQL = "update user set password=? where email=?";
        int update = jdbcTemplateObject.update(SQL, new Object[]{
            password,
            email
        });
        
        if(update != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void updateUser(User user){
        String SQL = "update user set firstname=?,surname=?,email=?,password=? where email=?";
        jdbcTemplateObject.update(SQL, new Object[]{user.getFirstName(),user.getSurname(),user.getEmail(),user.getPassword(),user.getEmail()});
    }
    
    public User getUserByEmail(String email){
        String SQL = "Select * from user where email=?";
        User user = (User)jdbcTemplateObject.queryForObject(SQL, new Object[]{email},new UserMapper());
        return user;
    }
    
    public void create(User user){
        
    }
}