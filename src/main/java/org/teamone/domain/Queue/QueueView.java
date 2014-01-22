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
    private int taksNr;

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

    public int getTaksNr() {
        return taksNr;
    }

    public void setTaksNr(int taksNr) {
        this.taksNr = taksNr;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof QueueView)) {
            return false;
        }
        final QueueView other = (QueueView) obj;
        if (this.queueId != other.queueId) {
            return false;
        }
        return true;
    }
    
    
    
}
