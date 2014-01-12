/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Kim
 */
public class UserRightsJDBCTemplate {
	DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserRights getUserRight(int user_id) {
        String SQL = "SELECT * FROM permissions WHERE user_id=?";
        UserRights userRight = (UserRights) jdbcTemplateObject.queryForObject(SQL, new Object[]{user_id}, new UserRightsMapper());
        return userRight;
    }
}
