package org.teamone.domain.Queue;

import java.sql.Date;


public class Queue {
    
    private int id;
    private Date date;
    private String users;
    private String firstNames;
    private String tasks;
    private String comment;
    private String status;
    private String location;
    private String subjectCode;

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public String toString() {
        return "Queue{" + "id=" + id + ", date=" + date + ", users=" + users + ", tasks=" + tasks + ", comment=" + comment + ", status=" + status + ", location=" + location + ", subjectCode=" + subjectCode + '}';
    }
    
}