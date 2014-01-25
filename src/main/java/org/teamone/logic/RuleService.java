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
	 * Replaces last character in the string s with the string 'with'
	 * 
	 * @param s
	 * @param character
	 * @param with
	 * @return 
	 */
    public String replaceLast(String s, String character, String with) {
        StringBuilder b = new StringBuilder(s);
        b.replace(s.lastIndexOf(character), s.lastIndexOf(character) + 1, with);
        s = b.toString();
        return s;
    }

	
	/**
	 * Takes a int[][] as argument and converts this into the string
	 * easily saved in a database. 
	 * 
	 * @param table
	 * @return 
	 */
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

	/**
     * Method that takes task rules on format (nr. of tasks){task1, task2,
     * task3,
     * Method will fail if the given string is not perfectly formatted.
     * @param nrOfTasks
     * @param rules
     * @return
     */
    public int[][] readRuleString(int nrOfTasks, String rules) {
        String[] ruleStrings = rules.split(";");
        int[][] tasks = new int[StringUtils.countMatches(rules, ";") + 1][nrOfTasks + 1];

        for (int i = 0; i < ruleStrings.length; i++) {
            String tempRule[] = ruleStrings[i].split("[,{}]");

            tasks[i][0] = Integer.parseInt(tempRule[0]);

            for (int j = 1; j < tempRule.length; j++) {
                int task = Integer.parseInt(tempRule[j]);
                tasks[i][task] = 1;
            }
        }
        return tasks;
    }

	/**
	 * Takes the list of approved tasks a user has, and compares this to the rules
	 * the subject requires. Returns whether or not the user has enough tasks done
	 * to be able to take exams.
	 * 
	 * @param taskDone
	 * @param rules
	 * @return 
	 */
    public boolean vertifyRequirements(boolean[] taskDone, int[][] rules) {
        int required = 0;
        int done = 0;

        for (int i = 0; i < rules.length; i++) {
            for (int j = 0; j < rules[i].length; j++) {
                if (j == 0) {
                    required = rules[i][j];
                } else {
                    if (taskDone[j - 1] && rules[i][j] == 1) {
                        done++;
                    }
                }
            }
            if (done < required) {
                return false;
            }
            done = 0;
        }

        return true;
    }
	
	/**
	 * Converts the rule-table to a readable text sentence
	 * 
	 * @param rules
	 * @return 
	 */
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

        return rulesString;
    }
}
