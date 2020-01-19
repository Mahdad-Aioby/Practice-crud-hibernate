package com.team3d.instagram.Persistent.Repositories;

import com.team3d.instagram.Persistent.Models.User;

import javax.persistence.Entity;

public class UserRepository extends CrudRepository<User,Long> {
    private static UserRepository userRepository;

    private UserRepository() {

    }
    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
