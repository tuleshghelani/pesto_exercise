package com.tulesh.springboot.service.impl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.tulesh.springboot.helper.UserFoundException;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreateUser_Success() throws Exception {
        User user = new User("testuser", "password");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getUsername(), createdUser.getUsername());
    }

    @Test
    public void testCreateUser_UserFoundException() {
        User user = new User("testuser", "password");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

        assertThrows(UserFoundException.class, () -> {
            userService.createUser(user);
        });
    }

    @Test
    public void testUpdateUser_Success() {
        User user = new User("testuser", "password");

        when(userRepository.save(user)).thenReturn(user);

        User updatedUser = userService.updateUser(user);

        assertNotNull(updatedUser);
        assertEquals(user.getUsername(), updatedUser.getUsername());
    }

    @Test
    public void testGetUser_Success() {
        String username = "testuser";
        User user = new User(username, "password");

        when(userRepository.findByUsername(username)).thenReturn(user);

        User retrievedUser = userService.getUser(username);

        assertNotNull(retrievedUser);
        assertEquals(username, retrievedUser.getUsername());
    }

    @Test
    public void testGetAllUsersList_Success() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));

        when(userRepository.findAll()).thenReturn(users);

        List<User> retrievedUsers = userService.getAllUsersList();

        assertNotNull(retrievedUsers);
        assertEquals(users.size(), retrievedUsers.size());
    }

    @Test
    public void testCount_Success() {
        long count = 5;

        when(userRepository.count()).thenReturn(count);

        assertEquals(count, userService.count());
    }

    @Test
    public void testDeleteUser_Success() {
        Long userId = 1L;

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}