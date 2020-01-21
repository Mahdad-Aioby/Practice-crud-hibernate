package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.PostRepository;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LikePost implements com.team3d.instagram.Domain.Services.LikePost {
    @Override
    public void Like(Long pid) {
        PostRepository postRepository = PostRepository.getInstance();
        Post post = postRepository.findById(pid);
        List<User> users = post.getUsers();
        users.add(AuthenticationService.getInstance().getLoginUser());
        post.setUsers(users);
        post.setLikes(post.getLikes()+1);
        postRepository.update(post);

    }
}
