package com.team3d.instagram.Domain.Services;

import com.team3d.instagram.Persistent.Models.Post;

import java.util.List;

public interface ShowAccountPosts {
    List<Post> accountPost(Long uid);
}
