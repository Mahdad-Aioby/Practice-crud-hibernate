package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Models.UserInfo;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

import java.util.function.Function;

public class ShowProfile implements com.team3d.instagram.Domain.Services.ShowProfile {
    @Override
    public void ShowProfile() {
        User user = AuthenticationService.getInstance().getLoginUser();
        UserInfo userInfo = new UserInfo();
        Function<User,UserInfo> infoFunction = u -> {
            userInfo.setFirstName(u.getFirstName());
            userInfo.setLastName(u.getLastName());
            userInfo.setUserName(u.getUsername());
            return userInfo;
        };
        System.out.println("user information:");
        System.out.println(user.toString());
        System.out.println("followers:");
        user.getFollowers().stream().map(infoFunction).forEach(System.out::println);
        System.out.println("following:");
        user.getFollowing().stream().map(infoFunction).forEach(System.out::println);
        System.out.println("posts:");
        user.getPosts().stream().forEach(System.out::println);

        //System.out.println(user.toString());
    }
}
