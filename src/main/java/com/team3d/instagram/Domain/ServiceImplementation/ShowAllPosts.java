package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Repositories.PostRepository;

import java.util.List;

public class ShowAllPosts implements com.team3d.instagram.Domain.Services.ShowAllPosts {
    @Override
    public List<Post> getAllPosts() {
        PostRepository postRepository = PostRepository.getInstance();
        return postRepository.findAll();
    }
}
