package org.teamone.domain.Role;

/**
 * TODO: Control usages, class may not be needed
 * @author Kim
 */
public class Role {

    private String email;
    private String subjectCode;
    private String roleName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Role() {

    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "email: " + email + ", subjectCode: " + subjectCode + ", rolename : " + roleName;
    }
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null ||!(obj instanceof Role)) return false;
		
		Role other = (Role) obj;
		if (!other.getEmail().equals(this.getEmail())) return false;
		if (!other.getRoleName().equals(this.getRoleName())) return false;
		if (!other.getSubjectCode().equals(this.getSubjectCode())) return false;
		
		return true;
	}
}
