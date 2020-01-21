package com.team3d.instagram;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Core.util.UserBuilder;
import com.team3d.instagram.Domain.ServiceImplementation.ShowAccountsPosts;
import com.team3d.instagram.Domain.Services.*;
import com.team3d.instagram.Persistent.DbContext.HibernateUtil;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Models.UserInfo;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

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
                System.out.println("9.show users posts");
                System.out.println("10.follow someone");
                System.out.println("11.unFollow someone");
                System.out.println("12.show all posts");
                System.out.println("9.logout");
                int choose = input.nextInt();
                switch(choose){
                    case 1:{
                        ShowProfile showProfile = new com.team3d.instagram.Domain.ServiceImplementation.ShowProfile();
                        showProfile.ShowProfile();
                        break;
                    }
                    case 2:{
                        EditProfile editProfile = new com.team3d.instagram.Domain.ServiceImplementation.EditProfile();
                        editProfile.edit();
                        break;
                    }
                    case 3:{
                        DeleteProfile deleteProfile = new com.team3d.instagram.Domain.ServiceImplementation.DeleteProfile();
                        deleteProfile.delete();
                        break;
                    }
                    case 4:{
                        System.out.println("Enter post title:");
                        String title = input.next();
                        System.out.println("Enter post Content:");
                        String content = input.next();

                        Post post = new Post();
                        post.setContent(content);
                        post.setTitle(title);
                        post.setUser(AuthenticationService.getInstance().getLoginUser());
                        AddPost addPost = new com.team3d.instagram.Domain.ServiceImplementation.AddPost();
                        addPost.add(post);
                        break;
                    }
                    case 5:{
                        System.out.println("Enter post title:");
                        String uTitle = input.next();
                        System.out.println("Enter post Content:");
                        String uContent = input.next();
                        Long uid = AuthenticationService.getInstance().getLoginUser().getId();
                        Post post = new Post();
                        post.setContent(uContent);
                        post.setTitle(uTitle);
                        EditPost editPost = new com.team3d.instagram.Domain.ServiceImplementation.EditPost();
                        editPost.edit(post);
                        break;
                    }
                    case 6:{
                        ShowPost showPost = new com.team3d.instagram.Domain.ServiceImplementation.ShowPost();
                        showPost.show().stream().forEach(System.out::println);
                        break;
                    }
                    case 7:{
                        ShowPost showPost = new com.team3d.instagram.Domain.ServiceImplementation.ShowPost();
                        showPost.show().stream().forEach(System.out::println);
                        System.out.println("Enter id to delete:");
                        Long pid = input.nextLong();
                        DeletePost deletePost = new com.team3d.instagram.Domain.ServiceImplementation.DeletePost();
                        deletePost.Delete(pid);
                        break;
                    }
                    case 8:{
                        System.out.println("Enter search field:");
                        String field = input.next();
                        System.out.println("Enter search subject:");
                        String subject = input.next();
                        SearchAccount searchAccount = new com.team3d.instagram.Domain.ServiceImplementation.SearchAccount();
                        UserInfo userInfo = new UserInfo();
                        Function<User,UserInfo> infoFunction = user -> {
                            userInfo.setFirstName(user.getFirstName());
                            userInfo.setLastName(user.getLastName());
                            userInfo.setUserName(user.getUsername());
                            return userInfo;
                        };
                        List<User> users = searchAccount.search(field,subject);
                        users.stream().map(infoFunction).forEach(System.out::println);
                        break;
                    }
                    case 9:{
                        System.out.println("Enter user id:");
                        Long id = input.nextLong();
                        ShowAccountPosts showAccountPosts = new ShowAccountsPosts();
                        showAccountPosts.accountPost(id).stream().forEach(System.out::println);
                        break;
                    }
                    case 10:{
                        System.out.println("Enter User id:");
                        Long id = input.nextLong();
                        FollowAUser followAUser = new com.team3d.instagram.Domain.ServiceImplementation.FollowAUser();
                        followAUser.follow(id);
                        break;
                    }
                    case 11:{
                        System.out.println("Enter user id:");
                        Long uid = input.nextLong();
                        UnFollow unFollow = new com.team3d.instagram.Domain.ServiceImplementation.UnFollow();
                        unFollow.unFollow(uid);
                        break;
                    }
                    case 12:{
                        ShowAllPosts showAllPosts = new com.team3d.instagram.Domain.ServiceImplementation.ShowAllPosts();
                        showAllPosts.getAllPosts().stream().forEach(System.out::println);
                        System.out.println("press 1 to like.if you want!");
                        int x = input.nextInt();
                        if(x==1) {
                            System.out.println("Enter post id:");
                            Long pid = input.nextLong();
                            LikePost likePost = new com.team3d.instagram.Domain.ServiceImplementation.LikePost();
                            likePost.Like(pid);
                            System.out.println("liked");
                        }

                        break;
                    }

                }
            }
        }
    }
}
