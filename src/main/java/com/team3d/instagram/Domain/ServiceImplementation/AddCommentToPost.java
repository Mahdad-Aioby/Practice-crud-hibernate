package com.team3d.instagram.Domain.ServiceImplementation;

import com.team3d.instagram.Core.Shared.AuthenticationService;
import com.team3d.instagram.Domain.Services.AddCommnetToPost;
import com.team3d.instagram.Persistent.Models.Comment;
import com.team3d.instagram.Persistent.Models.Post;
import com.team3d.instagram.Persistent.Repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class AddCommentToPost implements AddCommnetToPost {
    @Override
    public void Add(Comment comment, Long postId) {
        PostRepository postRepository = PostRepository.getInstance();
        Post post = postRepository.findById(postId);
        List<Comment> comments;
        comments = post.getComments();
        comment.setUser(AuthenticationService.getInstance().getLoginUser());
        comments.add(comment);
        post.setComments(comments);
        postRepository.update(post);
    }
}
