package org.teamone.domain.Role;

/**
 * TODO: Control usages, class may not be needed. Review getRole-function!
 * @author Kim
 */
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
    public Role getRole(int role_id) {
        String SQL = "SELECT * FROM role WHERE role_id=?";
        Role role = (Role) jdbcTemplateObject.queryForObject(SQL, new Object[]{role_id}, new RoleMapper());
        return role;
    }
    
    public void create(Role role){
        String SQL = "insert into user_subject (email, subject_code, rolename) values(?,?,?)";
        jdbcTemplateObject.update(SQL, new Object[]{
            role.getEmail(), 
            role.getSubjectCode(), 
            role.getRoleName()});
    }
}
