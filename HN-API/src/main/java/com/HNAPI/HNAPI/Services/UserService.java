package com.HNAPI.HNAPI.Services;

import com.HNAPI.HNAPI.payload.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUserById(Long id);
}
