/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teamone.domain.Rules;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Øystein
 */
public class TaskRuleJDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    public List<TaskRule> listTaskRule(){
        String SQL = "SELECT * FROM subject_task_rules";
        List<TaskRule> list = jdbcTemplateObject.query(SQL, new TaskRuleMapper());
        return list;
    }
    
    public TaskRule getTaskRule(String subjectcode){
        String SQL = "SELECT * from subject_task_rules WHERE subject_code = ?";
        TaskRule rule = jdbcTemplateObject.queryForObject(SQL, new Object[] {subjectcode}, new TaskRuleMapper());
        return rule;
    }
}
