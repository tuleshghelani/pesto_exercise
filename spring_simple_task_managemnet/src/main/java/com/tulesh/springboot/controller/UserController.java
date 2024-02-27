package com.tulesh.springboot.controller;

import com.tulesh.springboot.helper.UserFoundException;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import com.tulesh.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            throw new UserFoundException();
        }
        user.setProfile("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userService.createUser(user);
    }

    //Update User
    @PutMapping("/update-user")
    @CachePut(value = "name",key = "#user.username")
    public User updatingUser(@RequestBody User user ){
        log.info("Updating User {} " + user);
        return this.userService.updateUser(user);
    }

    @GetMapping("/{username}")
    @Cacheable(value = "name",key = "#username")
    public User getUser(@PathVariable("username") String username){
        log.info("Getting user with name {}.",username);
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    @CacheEvict(value = "name",allEntries = false,key="#userId")
    public void deleteUSer(@PathVariable("userId") Long userId){
        log.info("deleting  user with name {}.",userId);
        this.userService.deleteUser(userId);
    }

    @GetMapping("/gettingAllUserList")
    public List<User> allUserFromDB(){
            List<User> userlist = userService.getAllUsersList();
        log.info("getting all user from db {}.",userlist);

        return userlist;
    }

}
