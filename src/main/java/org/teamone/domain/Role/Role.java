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
}
