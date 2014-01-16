package org.teamone.domain.Subject;

public class Subject {

    private String code;
    private String name;
    private int status;
    private int nrOfTasks;

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
        return "Subject{" + "code=" + code + ", name=" + name + ", status=" + status + ", nr_of_tasks=" + nrOfTasks + '}';
    }
}