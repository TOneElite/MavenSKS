package org.teamone.domain.Role;

/**
 *
 * @author Kim
 */
public class Role {

    private String email;
    private String code;
    private String roleName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role(String email, String code, String roleName) {
        this.email = email;
        this.code = code;
        this.roleName = roleName;
    }

    public Role() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "email: " + email + ", code: " + code + ", rolename : " + roleName;
    }
}
