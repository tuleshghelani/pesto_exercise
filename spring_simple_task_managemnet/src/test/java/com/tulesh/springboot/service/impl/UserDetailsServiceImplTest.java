package com.tulesh.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        // Arrange
        User user = new User();
        user.setEmail("abc.def@example.org");
        user.setEnabled(true);
        user.setFirstName("abc");
        user.setId(1L);
        user.setLastName("def");
        user.setPassword("password");
        user.setPhone("6625550144");
        user.setProfile("Profile");
        user.setUsername("abcdef");
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(user);

        // Act
        UserDetails actualLoadUserByUsernameResult = userDetailsServiceImpl.loadUserByUsername("abcdef");

        // Assert
        verify(userRepository).findByUsername(eq("abcdef"));
        assertSame(user, actualLoadUserByUsernameResult);
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // Arrange
        when(userRepository.findByUsername(Mockito.<String>any()))
                .thenThrow(new UsernameNotFoundException("Invalid username!!!"));

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImpl.loadUserByUsername("abcdef"));
        verify(userRepository).findByUsername(eq("abcdef"));
    }
}
