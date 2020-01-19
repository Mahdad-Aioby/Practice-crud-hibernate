package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.UserRepository;
import org.hibernate.query.Query;

public class Login implements com.team3d.instagram.Domain.Services.Login {

    @Override
    public void Login(String username, String password) {
        Query<User> query = HibernateUtil.getSession().createQuery("from User where username=:username AND password=:password");
        query.setParameter("username",username);
        query.setParameter("password",password);
        User user;
        user=query.uniqueResult();
        HibernateUtil.getSession().beginTransaction();
        HibernateUtil.getSession().getTransaction().commit();
        if(user!=null){
            System.out.println("logged in as "+ user.getUsername());
            AuthenticationService.getInstance().setLoginUser(user);
        }
        else System.out.println("user not Exists!");
    }
}
