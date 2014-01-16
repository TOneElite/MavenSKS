package org.teamone.domain.userTasks;

/**
 *
 * @author Ida
 */
public class UserTasks {

    private String email;
    private String subjectCode;
    private int taskNr;

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
        return "Email: " + email + " Subject code: " + subjectCode + " Task Nr: " + taskNr;
    }

}
