package org.teamone.logic;


import org.apache.commons.lang.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Øystein
 */
public class RuleService {

    /**
     * Method that takes task rules on format (nr. of tasks){task1, task2,
     * task3,
     *
     * @param nrOfTasks
     * @param rules
     * @return
     */
    public String replaceLast(String s, String character, String with) {
        StringBuilder b = new StringBuilder(s);
        b.replace(s.lastIndexOf(character), s.lastIndexOf(character) + 1, with);
        s = b.toString();
        return s;
    }

    public String readTabletoRules(int[][] table) {
        String ruleString = "";
        for (int i = 0; i < table.length; i++) {
            ruleString += table[i][0] + "{";
            for (int j = 1; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    ruleString += j + ",";
                }
            }
            ruleString = replaceLast(ruleString, ",", "");
            ruleString += "};";
        }
        ruleString = replaceLast(ruleString, ";", "");
        return ruleString;
    }

    public int[][] readRuleString(int nrOfTasks, String rules) {
        String[] ruleStrings = rules.split(";");
        int[][] tasks = new int[StringUtils.countMatches(rules, ";") + 1][nrOfTasks + 1];

        System.out.println(tasks.length);

        for (int i = 0; i < ruleStrings.length; i++) {
            String tempRule[] = ruleStrings[i].split("[,{}]");
            System.out.println(tempRule.length);

            tasks[i][0] = Integer.parseInt(tempRule[0]);

            for (int j = 1; j < tempRule.length; j++) {
                int task = Integer.parseInt(tempRule[j]);
                tasks[i][task] = 1;
            }
        }
        return tasks;
    }

    public String[] readRulesNOR(int[][] rules) {
        String[] rulesString = new String[rules.length];

        for (int i = 0; i < rules.length; i++) {
            rulesString[i] = "Du trenger: " + rules[i][0] + " av følgende øvinger: ";
            for (int j = 1; j < rules[i].length; j++) {
                if (rules[i][j] == 1) {
                    rulesString[i] = rulesString[i] += j + ", ";
                }
            }
            rulesString[i] = replaceLast(rulesString[i], ",", "");
            rulesString[i] = replaceLast(rulesString[i], ",", " og");
        }

        for (String s : rulesString) {
            System.out.println(s);
        }

        return rulesString;
    }

}
