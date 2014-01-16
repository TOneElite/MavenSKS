package org.teamone.domain.userRights;

import org.teamone.domain.Subject.Subject;
import org.teamone.domain.Role.Role;

/**
 *
 * @author Kim
 */
public class UserRights {
	
	private Subject subject;
	private Role role;
	
	public UserRights(Subject subject, Role role){
		this.subject = subject;
		this.role = role;
	}
	
	public UserRights(){
	
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Subject getSubject(){
		return subject;
	}
	
	public Role getRole(){
		return role;
	}
	
	public void setRole(Role newRole){
		role = newRole;
	}
	
	@Override
	public String toString(){
		return "Subject details: " + subject.toString() + " Role details: " + role.toString();
	}
	
}
