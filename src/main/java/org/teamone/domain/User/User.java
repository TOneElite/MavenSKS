package org.teamone.domain.User;

import java.util.Date;

public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int enabled;
    private Date date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean checkUserData() {
        if (firstName == null || firstName.equals("")) {
            return false;
        }
        if (lastName == null || lastName.equals("")) {
            return false;
        }
        if (email == null || email.equals("")) {
            return false;
        }
        if (password == null || password.equals("")) {
            return false;
        }

        return true;
    }

}
