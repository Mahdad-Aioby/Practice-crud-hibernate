package com.team3d.instagram.Domain.Services;

import com.team3d.instagram.Persistent.Models.User;

import java.util.List;

public interface SearchAccount {
    List<User> search(String field,String subject);
}
