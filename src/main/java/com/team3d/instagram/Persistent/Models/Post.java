package com.team3d.instagram.Persistent.Models;

import org.hibernate.loader.collection.OneToManyJoinWalker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false,length = 100)
    private String title;

    @Column(name = "content",nullable = false,length = 100)
    private String content;

    @Column(name = "likes")
    private Long likes;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "liked_posts",
            joinColumns = { @JoinColumn(name = "pid") },
            inverseJoinColumns = { @JoinColumn(name = "uid") })
    private List<User> users = new ArrayList<>();

    public Post(String title, String content, Long likes, User user) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.user = user;
    }

    public Post() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +

                '}';
    }
}
