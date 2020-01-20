package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Domain.Services.ShowAccountPosts;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAccountsPosts implements ShowAccountPosts {
    @Override
    public List<Post> accountPost(Long uid) {
        Session mySession = HibernateUtil.getSession();
        Query<Post> query = mySession.createQuery("from post where user_id=:uid");
        query.setParameter("uid",uid);
        List<Post> posts;
        posts=query.list();
        return posts;
    }
}
