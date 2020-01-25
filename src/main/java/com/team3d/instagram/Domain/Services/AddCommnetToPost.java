package com.team3d.instagram.Domain.Services;

import com.team3d.instagram.Persistent.Models.Comment;

public interface AddCommnetToPost {
    void Add(Comment comment,Long postId);

}
