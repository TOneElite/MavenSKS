package org.teamone.domain.userRights;

import org.teamone.domain.Subject.Subject;
import org.teamone.domain.Role.Role;
import org.teamone.domain.User.User;

/**
 *
 * @author Oystein
 * 
 */
public class UserRights {
	
	private Subject subject;
	private Role role;
        private User user;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
