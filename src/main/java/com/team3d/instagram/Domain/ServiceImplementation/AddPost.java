package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Repositories.PostRepository;

public class AddPost implements com.team3d.instagram.Domain.Services.AddPost {
    @Override
    public void add(Post post) {
        PostRepository postRepository = PostRepository.getInstance();
        postRepository.save(post);

    }
}
