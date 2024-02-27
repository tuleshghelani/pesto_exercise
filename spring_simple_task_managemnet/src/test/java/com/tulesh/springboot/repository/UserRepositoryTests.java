package com.tulesh.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.tulesh.springboot.model.User;
import com.tulesh.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTests {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByUsername() {
        // Mock data
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");

        // Mock behavior
        when(userRepositoryMock.findByUsername("testuser")).thenReturn(user);

        // Test the service method that uses the repository
        User foundUser = userRepositoryMock.findByUsername("testuser");

        // Assertion
        assertEquals("testuser", foundUser.getUsername());
    }

    @Test
    public void testCount() {
        // Mock behavior
        when(userRepositoryMock.count()).thenReturn(5L);

        // Test the service method that uses the repository
        long userCount = userService.count();

        // Assertion
        assertEquals(5L, userCount);
    }
}

