package com.team3d.instagram.Core.Shared;

import com.team3d.instagram.Persistent.Models.User;
public class AuthenticationService {
    private User loginUser;

    private static AuthenticationService authenticationService = null;
    public static AuthenticationService getInstance() {
        if (authenticationService == null) {
            authenticationService = new AuthenticationService();
        }
        return authenticationService;
    }

    private AuthenticationService() {

    }

    public void setLoginUser(User user) {
        this.loginUser = user;
    }

    public User getLoginUser() {
        return loginUser;
    }
}
