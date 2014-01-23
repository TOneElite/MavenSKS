package org.teamone.domain.ApprovedTasks;

import java.util.Date;

/**
 *
 * @author Ida
 */
public class ApprovedTasks {

    private String email;
    private String subjectCode;
    private int taskNr;
    private Date approvedDate;
	private String approvedBy;

	

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	
	
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date date) {
        this.approvedDate = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getTaskNr() {
        return taskNr;
    }

    public void setTaskNr(int taskNr) {
        this.taskNr = taskNr;
    }

	@Override
	public String toString() {
		return "ApprovedTasks{" + "email=" + email + ", subjectCode=" + subjectCode + ", taskNr=" + taskNr + ", approvedDate=" + approvedDate + ", approvedBy=" + approvedBy + '}';
	}
}