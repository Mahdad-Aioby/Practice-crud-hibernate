package com.team3d.instagram.Domain.ServiceImplementation;

import com.mysql.cj.xdevapi.SessionFactory;
import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

import java.util.Date;
import java.util.Scanner;

public class EditProfile implements com.team3d.instagram.Domain.Services.EditProfile {
    @Override
    public void edit() {
        Scanner in = new Scanner(System.in);

        User user = AuthenticationService.getInstance().getLoginUser();
        UserRepository userRepository = UserRepository.getInstance();
        System.out.println("enter username:");
        String username = in.next();
        System.out.println("enter password:");
        String password = in.next();
        System.out.println("enter email:");
        String email = in.next();
        System.out.println("Enter first name:");
        String firstName = in.next();
        System.out.println("Enter last Name");
        String lastName = in.next();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.update(user);
        System.out.println("updated!");
    }
}
