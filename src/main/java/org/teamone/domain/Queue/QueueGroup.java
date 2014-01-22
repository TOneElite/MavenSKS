package org.teamone.domain.Queue;

import org.teamone.domain.User.User;

/**
 *
 * @author Kim
 */
public class QueueGroup {
	
	private int[] tasknr;
	private User[] users;

	
	public int[] getTasknr() {
		return tasknr;
	}

	public void setTasknr(int[] tasknr) {
		this.tasknr = tasknr;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	
	@Override
	public String toString() {
		return "QueueGroup{" + "tasknr=" + tasknr + ", users=" + users + '}';
	}
}
