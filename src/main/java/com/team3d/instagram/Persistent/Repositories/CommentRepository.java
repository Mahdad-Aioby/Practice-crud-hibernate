package com.team3d.instagram.Persistent.Repositories;

import com.team3d.instagram.Persistent.Models.Comment;

public class CommentRepository extends CrudRepository<Comment,Long> {

    private static CommentRepository commentRepository;

    private CommentRepository() {

    }
    public static CommentRepository getInstance() {
        if (commentRepository == null) {
            commentRepository = new CommentRepository();
        }
        return commentRepository;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
