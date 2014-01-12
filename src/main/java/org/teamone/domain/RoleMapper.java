
package org.teamone.domain;

/**
 *
 * @author Kim
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
        Role role = new Role();
        role.setRoleID(rs.getInt("role_id"));
        role.setRoleName(rs.getString("name"));
        return role;
    }
}