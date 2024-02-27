package com.tulesh.springboot.service;
import com.tulesh.springboot.model.User;

import java.util.List;


public interface UserService {

    public User createUser(User user) throws Exception;

    public User updateUser(User user);

    public User getUser(String username);

    public List<User> getAllUsersList();

    public long count();

    public void deleteUser(Long userId);
}
