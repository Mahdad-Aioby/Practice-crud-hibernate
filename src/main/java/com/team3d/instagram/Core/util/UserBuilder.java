package com.team3d.instagram.Core.util;


import com.team3d.instagram.Persistent.Models.User;

public class UserBuilder {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public UserBuilder Username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder Password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder Email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder FirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder LastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User Build(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }
}
