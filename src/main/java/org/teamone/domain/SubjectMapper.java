package org.teamone.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SubjectMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet rs, int i) throws SQLException {
        Subject subject = new Subject();
        subject.setCode(rs.getString("subject_code"));
        subject.setName(rs.getString("name"));
        subject.setStatus(rs.getInt("status"));
        return subject;
    }
}