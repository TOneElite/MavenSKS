package org.teamone.domain.Role;

/**
 * TODO: Control usages, class may not be needed. Review getRole-function!
 *
 * @author Kim
 */
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoleJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /*
     * Not used, does not function, no idea what it's supposed to do
     */
    public List<Role> getSubjectRoles(String email) {
        String SQL = "SELECT * FROM user_subject WHERE email=?";
        List<Role> roles= jdbcTemplateObject.query(SQL, new Object[]{email}, new RoleMapper());
        return roles;
    }
    
    public List<Role> getSubjectRolesCon(String email, String con) {
        if(con.equals(null)){
            String SQL = "SELECT * FROM user_subject WHERE email=?";
            List<Role> roles= jdbcTemplateObject.query(SQL, new Object[]{email}, new RoleMapper());
            return roles;
        }else{
            String a = "%"+con+"%";
             String SQL = "SELECT * FROM user_subject WHERE email=? AND subject_code LIKE ?";
            List<Role> roles = jdbcTemplateObject.query(SQL, new Object[]{email,a}, 
                    new RoleMapper(){
            });
            return roles;
        }
    }
    public void create(Role role) {
        String SQL = "insert into user_subject (email, subject_code, rolename) values(?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            role.getEmail(),
            role.getSubjectCode(),
            role.getRoleName()});
    }
    
    public List<Role> getStudentSubjects(String email){
        String SQL = "SELECT * FROM user_subject WHERE email=? AND rolename='ROLE_USER'";
        List<Role> studentsubjects= jdbcTemplateObject.query(SQL, new Object[]{email}, new RoleMapper());
        return studentsubjects;
    }
    
    public List<Role> getTeacherSubjects(String email){
        String SQL = "SELECT * FROM user_subject WHERE email=? AND rolename='ROLE_TEACHER'";
        List<Role> studentsubjects= jdbcTemplateObject.query(SQL, new Object[]{email}, new RoleMapper());
        return studentsubjects;
    }
}
