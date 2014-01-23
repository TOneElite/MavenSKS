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
	
	@Override
	public boolean equals(Object obj){
		if(obj == null ||!(obj instanceof UserRights)) return false;
		
		UserRights other = (UserRights) obj;
		if (!other.getSubject().equals(this.getSubject())) return false;
		if (!other.getRole().equals(this.getRole())) return false;
		if (!other.getUser().equals(this.getUser())) return false;
		return true;
	}
}
