package com.team3d.instagram.Domain.Services;

import com.team3d.instagram.Persistent.Models.User;
import com.team3d.instagram.Persistent.Models.UserInfo;

import java.util.List;

public interface SearchAccount {
    UserInfo search(String subject);
}
