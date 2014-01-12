/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Kim
 */
public class UserRightsMapper implements RowMapper<UserRights> {

    @Override
    public UserRights mapRow(ResultSet rs, int i) throws SQLException {
        UserRights userRight = new UserRights();
        
		// Her blir det fest :(
		// userRight.setCode(rs.getString("subject_code"));
        // userRight.setName(rs.getString("name"));
        
		return userRight;
    }
}