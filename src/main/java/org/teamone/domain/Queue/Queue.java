package org.teamone.domain.Queue;

import java.sql.Date;


public class Queue {
    
    private int id;
    private Date date;
    private QueueGroup group;
    private String comment;
    private String status;
    private String location;
    private String subjectCode;

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

	public QueueGroup getGroup() {
		return group;
	}

	public void setGroup(QueueGroup group) {
		this.group = group;
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
		return "Queue{" + "id=" + id + ", date=" + date + ", group=" + group + ", comment=" + comment + ", status=" + status + ", location=" + location + ", subjectCode=" + subjectCode + '}';
	}

    
    
}