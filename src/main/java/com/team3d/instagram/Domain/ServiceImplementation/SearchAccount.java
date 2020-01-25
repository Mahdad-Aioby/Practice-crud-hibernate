package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Models.UserInfo;
import com.team3d.instagram.Persistent.Repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchAccount implements com.team3d.instagram.Domain.Services.SearchAccount {
    @Override
    public UserInfo search(String subject) {
        UserRepository userRepository = UserRepository.getInstance();
        List<User> users = userRepository.findAll();
        UserInfo userInfo = new UserInfo();
        Function<User, UserInfo> infoFunction = user -> {
            userInfo.setFirstName(user.getFirstName());
            userInfo.setLastName(user.getLastName());
            userInfo.setUserName(user.getUsername());
            return userInfo;
        };
        ArrayList<UserInfo> userInfos = users.stream().filter(user -> user.getUsername().equals(subject)).map(infoFunction).collect(Collectors.toCollection(ArrayList::new));


        return userInfos.get(0);
    }
}
