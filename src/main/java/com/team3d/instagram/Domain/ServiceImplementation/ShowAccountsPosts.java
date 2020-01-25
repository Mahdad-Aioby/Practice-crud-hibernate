package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Domain.Services.ShowAccountPosts;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAccountsPosts implements ShowAccountPosts {
    @Override
    public List<Post> accountPost(Long uid) {
        UserRepository userRepository = UserRepository.getInstance();
        User user = userRepository.findById(uid);
        List<Post> posts;
        posts=user.getPosts();
        return posts;
    }
}
