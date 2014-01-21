package org.teamone.domain.Queue;

import java.util.Date;

public class Queue {
    
    private int id;
    private Date date;
    private String users;
    private String ov;
    private String comment;
    private String status;
    private String tables; // Has the name "location" in the database
    private String subjectCode;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getUsers() {
	return users;
    }

    public void setUsers(String users) {
	this.users = users;
    }
    
    public String getOv() {
	return ov;
    }

    public void setOv(String ov) {
	this.ov = ov;
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

    public String getTables() {
	return tables;
    }

    public void setTables(String tables) {
	this.tables = tables;
    }
    
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public String toString() {
        return "Queue{" + "id=" + id + ", date=" + date + ", users=" + users + ", ov=" + ov + ", comment=" + comment + ", status=" + status + ", tables=" + tables + ", subjectCode=" + subjectCode + '}';
    }
    
}