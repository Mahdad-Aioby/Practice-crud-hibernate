package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;

public class Logout implements com.team3d.instagram.Domain.Services.Logout {
    @Override
    public void logout() {
        AuthenticationService.getInstance().setLoginUser(null);
        System.out.println("logged out!");
    }
}
