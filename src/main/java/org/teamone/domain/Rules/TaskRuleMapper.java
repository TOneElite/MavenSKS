/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.teamone.domain.Rules;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.teamone.domain.Subject.Subject;

/**
 *
 * @author Øystein
 */
public class TaskRuleMapper implements RowMapper<TaskRule> {

    @Override
    public TaskRule mapRow(ResultSet rs, int i) throws SQLException {
        TaskRule taskRule = new TaskRule();
        taskRule.setRulestring(rs.getString("rulestring"));
        taskRule.setSubject(rs.getString("subject_code"));
        return taskRule;
    }
}
