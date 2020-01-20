package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SearchAccount implements com.team3d.instagram.Domain.Services.SearchAccount {
    @Override
    public List<User> search(String filed,String subject) {
        Session mySession = HibernateUtil.getSession();
        Query<User> query = mySession.createQuery("from user where "+filed+"=:subject");
        query.setParameter("subject",subject);
        List<User> users;
        users= query.getResultList();

        return users;
    }
}
