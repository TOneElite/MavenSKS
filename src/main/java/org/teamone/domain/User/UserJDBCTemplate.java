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
        if(con == null){
            String SQL = "SELECT * FROM users ORDER BY lastname ASC" ;
            List<User> user = jdbcTemplateObject.query(SQL, new UserMapper());
            return user;
        }else{
            String a = "%"+con+"%";
            String SQL = "SELECT * FROM users WHERE lastname LIKE ?";
            List<User> user = jdbcTemplateObject.query(SQL, new Object[]{a}, 
                    new UserMapper(){
            });
            return user;
        }
    }
    
    public boolean setPassword(String password, String email){
        String SQL = "UPDATE users SET password=? WHERE email=?";
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
        String SQL = "UPDATE users SET firstname=?,lastname=?,email=?,enabled=?,password=? WHERE email=?";
        jdbcTemplateObject.update(SQL, new Object[]{user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getEnabled(),user.getEmail()});
    }
    
    public User getUserByEmail(String email){
        String SQL = "SELECT * FROM users WHERE email=?";
        User user = (User)jdbcTemplateObject.queryForObject(SQL, new Object[]{email},new UserMapper());
        return user;
    }
    
    public List<User> getUserBySubject(String subject, String role){
        String SQL = "SELECT * FROM users NATURAL JOIN user_subject WHERE user_subject.subject_code = ? AND user_subject.rolename = ?";
        List<User> user = jdbcTemplateObject.query(SQL, new Object[]{subject, role}, new UserMapper());
        return user;
    }
    
    public void create(User user){
        System.out.println(user.toString());
        String SQL = "INSERT INTO users (email, firstname, lastname, password, enabled, registerdate) values(?,?,?,?,1,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            user.getEmail(),
            user.getFirstName(),
            user.getLastName(),
            user.getPassword(),
            user.getDate()
        });
    }
    
}