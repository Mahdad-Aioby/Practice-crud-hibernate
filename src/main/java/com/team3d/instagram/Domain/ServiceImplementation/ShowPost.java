package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowPost implements com.team3d.instagram.Domain.Services.ShowPost {

    @Override
    public List<Post> show() {
        User user = AuthenticationService.getInstance().getLoginUser();
        List<Post> posts;
        posts = user.getPosts();

        return posts;
    }
}
