package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Persistent.Repositories.UserRepository;

public class DeleteProfile implements com.team3d.instagram.Domain.Services.DeleteProfile {
    @Override
    public void delete() {
        Long id= AuthenticationService.getInstance().getLoginUser().getId();
        AuthenticationService.getInstance().setLoginUser(null);
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.removeById(id);
        System.out.println("Account Deleted!");
    }
}
