package org.teamone.domain.Queue;

public class QueueApprove {
    
    private int queueId;
    private String email;
    private int taskNr;

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
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

    public void setTaskNr(int taskNr) {
        this.taskNr = taskNr;
    }
    
    public String toString(){
        return queueId+";"+email+";"+taskNr;
    }
    
}
