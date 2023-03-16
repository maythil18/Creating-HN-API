package com.HNAPI.HNAPI.payload;

public class UserDto {
    private Long id;
    private String hackerNewsHandle;

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

    public UserDto(Long id, String hackerNewsHandle) {
        this.id = id;
        this.hackerNewsHandle = hackerNewsHandle;
    }
}

