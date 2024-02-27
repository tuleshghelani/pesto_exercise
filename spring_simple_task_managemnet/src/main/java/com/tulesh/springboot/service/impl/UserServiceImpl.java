package com.tulesh.springboot.service.impl;

import com.tulesh.springboot.helper.UserFoundException;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import com.tulesh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            throw new UserFoundException();
        } else {
            //Create User Here
            // Save All User
            local = this.userRepository.save(user);
        }

        return local;
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsersList() {
        return this.userRepository.findAll();
    }

    @Override
    public long count() {
        return this.userRepository.count();
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

}
