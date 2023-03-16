package com.HNAPI.HNAPI.Entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

public class Comment {


    @Entity
    @Table(name = "comments")
    public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public Comment(Long id, String text, User user, Story story, List<Comment> childComments, Comment parentComment) {
            this.id = id;
            this.text = text;
            this.user = user;
            this.story = story;
            this.childComments = childComments;
            this.parentComment = parentComment;
        }

        @Column(name = "text")
        private String text;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "story_id")
        private Story story;

        @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Comment> childComments;

        @ManyToOne
        @JoinColumn(name = "parent_comment_id")
        private Comment parentComment;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Story getStory() {
            return story;
        }

        public void setStory(Story story) {
            this.story = story;
        }

        public List<Comment> getChildComments() {
            return childComments;
        }

        public void setChildComments(List<Comment> childComments) {
            this.childComments = childComments;
        }

        public Comment getParentComment() {
            return parentComment;
        }

        public void setParentComment(Comment parentComment) {
            this.parentComment = parentComment;
        }
    }

}
