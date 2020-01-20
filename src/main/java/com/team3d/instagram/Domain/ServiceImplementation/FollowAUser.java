package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class FollowAUser implements com.team3d.instagram.Domain.Services.FollowAUser {

    @Override
    public void follow(Long userId) {
        //---------------following
        UserRepository userRepository = UserRepository.getInstance();
        User userToFollow = userRepository.findById(userId);
        User me = userRepository.findById(AuthenticationService.getInstance().getLoginUser().getId());
        List<User> following = new ArrayList<>();
        following.add(userToFollow);
        me.setFollowing(following);
        userRepository.update(me);
        System.out.println("you are following user : "+userToFollow.getUsername() + " now!");

        //-------------followers

        List<User> followers = new ArrayList<>();
        followers.add(me);
        userToFollow.setFollowers(followers);
        userRepository.update(userToFollow);
    }
}
