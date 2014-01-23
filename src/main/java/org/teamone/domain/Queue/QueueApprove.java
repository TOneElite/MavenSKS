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
    
	@Override
	public boolean equals(Object obj){
		if(obj == null ||!(obj instanceof QueueApprove)) return false;
		
		QueueApprove other = (QueueApprove) obj;
		if (!other.getEmail().equals(this.getEmail())) return false;
		if (other.getQueueId() != this.getQueueId()) return false;
		if (other.getTaskNr() != this.getTaskNr()) return false;
		
		return true;
	}
}
