/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.userRights;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.teamone.domain.Role.Role;
import org.teamone.domain.Subject.Subject;
import org.teamone.domain.User.User;

/**
 *
 * @author Oystein
 */
public class UserRightsMapper implements RowMapper<UserRights> {

    @Override
    public UserRights mapRow(ResultSet rs, int i) throws SQLException {
        UserRights userRight = new UserRights();

        userRight.setRole(rs.getObject("role", Role.class));
        userRight.setSubject(rs.getObject("subject", Subject.class));
        userRight.setUser(rs.getObject("user", User.class));
        
        return userRight;
    }
}
