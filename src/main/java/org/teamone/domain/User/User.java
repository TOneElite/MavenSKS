package org.teamone.domain.User;

import java.util.Date;

public class User {

    private String firstName;
    private String surname;
    private String email;
    private String password;
    private Date date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date =  date;
    }
    
    public boolean checkUserData(){
        if(firstName == null || firstName.equals(""))
            return false;
        if(surname == null || surname.equals(""))
            return false;
        if(email == null || email.equals(""))
            return false;
        if(password == null || password.equals(""))
            return false;
        
        return true;
    }

    @Override
    public String toString() {
        return "firstname: " + firstName + ", surname: " + surname + ", email: " + email + ", password: " + password;
    }
}
