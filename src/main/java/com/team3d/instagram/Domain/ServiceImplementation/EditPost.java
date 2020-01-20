package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Domain.Services.EditProfile;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Repositories.PostRepository;

public class EditPost implements com.team3d.instagram.Domain.Services.EditPost {

    @Override
    public void edit(Post post) {
        PostRepository postRepository = PostRepository.getInstance();
        postRepository.update(post);
        System.out.println("updated!!");
    }
}
