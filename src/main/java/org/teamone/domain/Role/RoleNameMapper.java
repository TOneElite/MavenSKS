package org.teamone.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleNameMapper implements RowMapper<RoleName> {
    
    @Override
    public RoleName mapRow(ResultSet rs, int i) throws SQLException {
        RoleName roleName = new RoleName();
        roleName.setRoleName(rs.getString("rolename"));
        
        return roleName;
    }
    
}
