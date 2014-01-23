package org.teamone.domain.Queue;

/**
 *
 * @author Kim
 */
public class QueueGroup {

    private int[] taskNrs;
    private String[] users;

    public int[] getTaskNrs() {
        return taskNrs;
    }

    public void setTaskNrs(int[] tasknr) {
        this.taskNrs = tasknr;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "QueueGroup{" + "tasknr=" + taskNrs + ", users=" + users + '}';
    }
}
