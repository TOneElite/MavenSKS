package org.teamone.domain.Queue;

import java.sql.Date;

public class QueueView {
    
    private int queueId;
    private String subjectCode;
    private String comment;
    private String status;
    private String location;
    private Date timestamp;
    private String email;
    private int taskNr;

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTaskNr() {
        return taskNr;
    }

    public void setTaskNr(int taksNr) {
        this.taskNr = taksNr;
    }

    
    @Override
    public boolean equals(Object obj) {
        if(obj == null ||!(obj instanceof QueueView)) return false;
		
		QueueView other = (QueueView) obj;
		if (!other.getEmail().equals(this.getEmail())) return false;
		if (other.getQueueId() != this.getQueueId()) return false;
		if (other.getTaskNr() != this.getTaskNr()) return false;
		if (!other.getComment().equals(this.getComment())) return false;
		if (!other.getLocation().equals(this.getLocation())) return false;
		if (!other.getStatus().equals(this.getStatus())) return false;
		if (!other.getSubjectCode().equals(this.getSubjectCode())) return false;
		// if (!other.getTimestamp().equals(this.getTimestamp())) return false; TODO: Currently buggy
		
		return true;
    }
    
}
