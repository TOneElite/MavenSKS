package org.teamone.domain;

/**
 *
 * @author Kim
 */
public class TaskRule {
	String regex;
	int taskCount;

	public TaskRule(String regex, int taskCount) {
		this.regex = regex;
		this.taskCount = taskCount;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}
}
