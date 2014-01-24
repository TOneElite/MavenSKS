package org.teamone.domain.Subject;

public class Subject {

    private String code;
    private String name;
    private int status;
    private int nrOfTasks;
    private int[][] rules;
    private String ruleString;

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    public int[][] getRules() {
        return rules;
    }

    public void setRules(int[][] rules) {
        this.rules = rules;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNrOfTasks() {
        return nrOfTasks;
    }

    public void setNrOfTasks(int nr_of_tasks) {
        this.nrOfTasks = nr_of_tasks;
    }

    @Override
    public String toString() {
        return "Subject{" + "code=" + code + ", name=" + name + ", status=" + status + ", nrOfTasks=" + nrOfTasks + ", rules=" + rules + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Subject)) {
            return false;
        }

        Subject other = (Subject) obj;
        if (!other.getName().equals(this.getName())) {
            return false;
        }
        if (other.getNrOfTasks() != this.getNrOfTasks()) {
            return false;
        }
        for (int i = 0; i < other.getRules().length; i++) {
            for (int j = 0; j < other.getRules()[i].length; i++) {
                if (other.getRules()[i][j] != this.getRules()[i][j]) {
                    return false;
                }
            }
        }
        if (other.getStatus() != this.getStatus()) {
            return false;
        }
        if (other.getCode().equals(this.getCode())) {
            return false;
        }
        return true;
    }
}
