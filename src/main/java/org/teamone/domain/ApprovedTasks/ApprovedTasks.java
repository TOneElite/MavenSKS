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
	
	@Override
	public boolean equals(Object obj){
		if(obj == null ||!(obj instanceof ApprovedTasks)) return false;
		
		ApprovedTasks other = (ApprovedTasks) obj;
		if (!other.getEmail().equals(this.getEmail())) return false;
		if (!other.getSubjectCode().equals(this.getSubjectCode())) return false;
		if (other.getTaskNr() != this.getTaskNr()) return false;
		if (!other.getApprovedDate().equals(this.getApprovedDate())) return false; // TODO: Dates are buggy, review this.
		if (!other.getApprovedBy().equals(this.getApprovedBy())) return false;
		
		return true;
	}
}
