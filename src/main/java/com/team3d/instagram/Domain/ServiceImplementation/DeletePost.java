package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Domain.Services.DeleteProfile;
import com.team3d.instagram.Persistent.Repositories.PostRepository;

public class DeletePost implements com.team3d.instagram.Domain.Services.DeletePost {
    @Override
    public void Delete(Long id) {
        PostRepository postRepository = PostRepository.getInstance();
        postRepository.removeById(id);
        System.out.println("post deleted!");
    }
}
