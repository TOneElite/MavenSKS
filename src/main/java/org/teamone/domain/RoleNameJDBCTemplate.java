package org.teamone.domain;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class RoleNameJDBCTemplate {
    
    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public List<RoleName> listRoleName(){
        String SQL = "SELECT * FROM permissions";
        List<RoleName> roleName = jdbcTemplateObject.query(SQL, new RoleNameMapper());
        return roleName;
    }
}
