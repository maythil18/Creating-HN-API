package com.HNAPI.HNAPI.Entity;

import org.apache.catalina.User;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getTimeOfSubmission() {
        return timeOfSubmission;
    }

    public void setTimeOfSubmission(LocalDateTime timeOfSubmission) {
        this.timeOfSubmission = timeOfSubmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "score")
    private int score;

    @Column(name = "time_of_submission")
    private LocalDateTime timeOfSubmission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Story(Long id, String title, String url, int score, LocalDateTime timeOfSubmission, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.score = score;
        this.timeOfSubmission = timeOfSubmission;
        this.user = user;
        this.comments = comments;
    }

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // constructors, getters and setters, and other methods
}
