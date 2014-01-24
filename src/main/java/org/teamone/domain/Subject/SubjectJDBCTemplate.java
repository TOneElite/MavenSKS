package org.teamone.domain.Subject;

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

    public Subject getSubject(String subjectCode) {
        String SQL = "SELECT * FROM subject WHERE subject_code=?";
        Subject subject = (Subject) jdbcTemplateObject.queryForObject(SQL, new Object[]{subjectCode}, new SubjectMapper());
        return subject;
    }

    public List<Subject> listSubjects() {
        String SQL = "SELECT * FROM subject";
        List<Subject> subjects = jdbcTemplateObject.query(SQL, new SubjectMapper());
        return subjects;
    }

    public void setStatus(int status, String subjectCode) {
        String SQL = "UPDATE subject SET status = ? where subject_code = ?";
        jdbcTemplateObject.update(SQL, status, subjectCode);
    }

    public void addSubject(Subject subject) {
        String SQL = "INSERT INTO subject (subject_code, subject_name, status, nr_of_tasks, rulestring) VALUES (?,?,0,0,1)";
        jdbcTemplateObject.update(SQL, new Object[]{
            subject.getCode(),
            subject.getName(),});
    }

    public void setRuleString(String subjectCode, String ruleString) {
        String SQL = "UPDATE subject SET rulestring = ? where subject_code = ?";
        jdbcTemplateObject.update(SQL, new Object[]{ruleString, subjectCode});
    }
    
    public List<Subject> getYourSubjects(String rolename, String email){
        String SQL = "SELECT subject.* FROM user_subject NATURAL JOIN subject WHERE rolename=? AND email=?";
        List<Subject> subjects = jdbcTemplateObject.query(SQL, new Object[]{rolename, email}, new SubjectMapper());
        return subjects;
    }
}
