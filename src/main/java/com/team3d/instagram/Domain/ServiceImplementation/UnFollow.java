package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UnFollow implements com.team3d.instagram.Domain.Services.UnFollow {
    @Override
    public void unFollow(Long userId) {
        //---------------following
        UserRepository userRepository = UserRepository.getInstance();
        User userToUnFollow = userRepository.findById(userId);
        User me = userRepository.findById(AuthenticationService.getInstance().getLoginUser().getId());
        List<User> following;
        following = me.getFollowing();
        following.remove(userToUnFollow);
        me.setFollowing(following);
        userRepository.update(me);
        System.out.println("you are following user : "+userToUnFollow.getUsername() + " now!");

        //-------------followers

        List<User> followers = userToUnFollow.getFollowers();
        followers.remove(me);
        userToUnFollow.setFollowers(followers);
        userRepository.update(userToUnFollow);
    }
}
