package org.teamone.domain;

/**
 *
 * @author Kim
 */
public class Role {
	
	private int roleID;
	private String roleName;

	public Role(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
	}
	
	public Role(){
		
	}
	
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "roleID: " + roleID + ", roleName: " + roleName;
	}
}
