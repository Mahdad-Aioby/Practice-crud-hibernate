package com.team3d.instagram;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Core.util.UserBuilder;
import com.team3d.instagram.Domain.Services.Login;
import com.team3d.instagram.Domain.Services.Register;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.User;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Scanner input = new Scanner(System.in);

        while (true){
            if(AuthenticationService.getInstance().getLoginUser()==null){
                System.out.println("what do you want?");
                System.out.println("1.Register");
                System.out.println("2.Login");
                int choosen = input.nextInt();
                switch (choosen){
                    case 1:{
                        UserBuilder userBuilder = new UserBuilder();
                        System.out.println("Enter Username:");
                        String username=input.next();
                        System.out.println("Enter Password:");
                        String password = input.next();
                        System.out.println("Enter Email:");
                        String email = input.next();
                        System.out.println("Enter First Name:");
                        String firstName = input.next();
                        System.out.println("Enter Last Name:");
                        String lastName = input.next();

                        User user = userBuilder
                                .Username(username)
                                .Password(password)
                                .Email(email)
                                .FirstName(firstName)
                                .LastName(lastName)
                                .Build();

                        Register register = new com.team3d.instagram.Domain.ServiceImplementation.Register();
                        Long id=  register.register(user);
                        System.out.println("User Created By id : "+id);
                        break;

                    }
                    case 2:{
                        System.out.println("Enter username:");
                        String username = input.next();
                        System.out.println("Enter password:");
                        String password = input.next();
                        Login login = new com.team3d.instagram.Domain.ServiceImplementation.Login();
                        login.Login(username,password);
                        break;
                    }
                }
            }
            else {
                System.out.println("what do you want?");
                System.out.println("1.show my profile");
                System.out.println("2.edit my profile");
                System.out.println("3.delete my profile");
                System.out.println("4.add post");
                System.out.println("5.edit post");
                System.out.println("6.show posts");
                System.out.println("7.delete post");
                System.out.println("8.search account");
                System.out.println("9.logout");
                int choose = input.nextInt();

            }
        }
    }
}
