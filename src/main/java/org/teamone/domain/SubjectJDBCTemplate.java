package org.teamone.domain;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class SubjectJDBCTemplate {

    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public Subject getSubject(int subjectCode) {
        String SQL = "SELECT * FROM subject WHERE subject_code=?";
        Subject subject = (Subject) jdbcTemplateObject.queryForObject(SQL, new Object[]{subjectCode}, new SubjectMapper());
        return subject;
    }

    public List<Subject> listSubjects() {
        String SQL = "SELECT * FROM subject";
        List<Subject> subjects = jdbcTemplateObject.query(SQL, new SubjectMapper());
        return subjects;
    }
}