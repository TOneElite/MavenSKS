package org.teamone.domain.User;

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

    public List<User> listUsers() {
        String SQL = "SELECT * FROM users ORDER BY lastname ASC" ;
        List<User> user = jdbcTemplateObject.query(SQL, new UserMapper());
        return user;
    }
    
    public List<User> listUsersCon(String con) {
        String a = "%"+con+"%";
        String SQL = "SELECT * FROM users WHERE lastname LIKE ?";
        List<User> user = jdbcTemplateObject.query(SQL, new Object[]{a}, 
                new UserMapper(){
        });
        return user;
    }
    
    public boolean setPassword(String password, String email){
        String SQL = "update users set password=? where email=?";
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
        String SQL = "update users set firstname=?,lastname=?,email=?,password=? where email=?";
        jdbcTemplateObject.update(SQL, new Object[]{user.getFirstName(),user.getSurname(),user.getEmail(),user.getPassword(),user.getEmail()});
    }
    
    public User getUserByEmail(String email){
        String SQL = "Select * from users where email=?";
        User user = (User)jdbcTemplateObject.queryForObject(SQL, new Object[]{email},new UserMapper());
        return user;
    }
    
    public void create(User user){
        System.out.println(user.toString());
        String SQL = "insert into users (email, firstname, lastname, password, enabled, registerdate) values(?,?,?,?,1,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            user.getEmail(),
            user.getFirstName(),
            user.getSurname(),
            user.getPassword(),
            user.getDate()
        });
    }
    
}