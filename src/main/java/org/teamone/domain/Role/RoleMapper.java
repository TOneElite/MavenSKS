
package org.teamone.domain.Role;

/**
 * TODO: Control usages, class may not be needed
 * @author Kim
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
        Role role = new Role();
        role.setEmail(rs.getString("email"));
        role.setSubjectCode(rs.getString("subject_code"));
        role.setRoleName(rs.getString("rolename"));
        return role;
    }
}