package org.teamone.domain;

import java.util.Date;

public class Queue {
    
    private int id;
    private Date date;
    private String users;
    private String ov;
    private String comment;
    private String status;
    private String tables;

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
}