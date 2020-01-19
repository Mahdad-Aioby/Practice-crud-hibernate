package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.CrudRepository;
import com.team3d.instagram.Persistent.Repositories.UserRepository;
import org.hibernate.Session;

public class Register implements com.team3d.instagram.Domain.Services.Register {
    @Override
    public Long register(User user) {
        UserRepository userRepository = UserRepository.getInstance();
        User createdUser = userRepository.save(user);
        return createdUser.getId();
    }
}
