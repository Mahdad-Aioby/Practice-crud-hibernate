package com.team3d.instagram.Persistent.Models;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "comment",nullable = false,length = 500)
    private String comment;

    @Column(name = "date",nullable = false)
    private Date dateOfComment;

    public Comment() {
    }

    public Comment(String comment, Date dateOfComment) {
        this.comment = comment;
        this.dateOfComment = dateOfComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", comment='" + comment + '\'' +
                ", dateOfComment=" + dateOfComment +
                '}';
    }
}
