package org.teamone.domain.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.teamone.logic.RuleService;

public class SubjectMapper implements RowMapper<Subject> {

    @Override
    public Subject mapRow(ResultSet rs, int i) throws SQLException {
        Subject subject = new Subject();
        subject.setCode(rs.getString("subject_code"));
        subject.setName(rs.getString("subject_name"));
        subject.setStatus(rs.getInt("status"));
        subject.setNrOfTasks(rs.getInt("nr_of_tasks"));
        subject.setRules(new RuleService().readRuleString(rs.getInt("nr_of_tasks"), rs.getString("rulestring")));
        return subject;
    }
}