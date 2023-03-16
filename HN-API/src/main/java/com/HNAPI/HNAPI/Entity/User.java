package com.HNAPI.HNAPI.Entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;

public class User {

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getHackerNewsHandle() {
            return hackerNewsHandle;
        }

        public void setHackerNewsHandle(String hackerNewsHandle) {
            this.hackerNewsHandle = hackerNewsHandle;
        }

        public User(Long id, String hackerNewsHandle) {
            this.id = id;
            this.hackerNewsHandle = hackerNewsHandle;
        }

        @Column(name = "hacker_news_handle")
        private String hackerNewsHandle;


    }

}
