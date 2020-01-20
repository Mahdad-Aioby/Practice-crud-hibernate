package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.Post;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShowPost implements com.team3d.instagram.Domain.Services.ShowPost {

    @Override
    public List<Post> show() {
        Long uid = AuthenticationService.getInstance().getLoginUser().getId();
        Session session = HibernateUtil.getSession();
        Query<Post> query = session.createQuery("from post where user_id=:id");
        query.setParameter("id", uid);
        List<Post> posts;
        posts = query.list();

        return posts;
    }
}
