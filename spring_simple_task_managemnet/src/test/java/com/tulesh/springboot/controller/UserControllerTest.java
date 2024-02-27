package com.tulesh.springboot.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import com.tulesh.springboot.service.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#allUserFromDB()}
     */
    @Test
    void testAllUserFromDB() throws Exception {
        // Arrange
        when(userService.getAllUsersList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/gettingAllUserList");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    @Disabled("TODO: Test case")
    void testCreateUser() throws Exception {

        // Arrange
        UserController userController = new UserController();

        User user = new User();
        user.setEmail("templName.tempfName@example.org");
        user.setEnabled(true);
        user.setFirstName("templName");
        user.setId(1L);
        user.setLastName("tempfName");
        user.setPassword("password");
        user.setPhone("6625550144");
        user.setProfile("Profile");
        user.setUsername("templNametempfName");

        // Act
        userController.createUser(user);
    }

    @Test
    void testGetUser() throws Exception {
        // Arrange
        User user = new User();
        user.setEmail("templName.tempfName@example.org");
        user.setEnabled(true);
        user.setFirstName("templName");
        user.setId(1L);
        user.setLastName("tempfName");
        user.setPassword("password");
        user.setPhone("6625550144");
        user.setProfile("Profile");
        user.setUsername("templNametempfName");
        when(userService.getUser(Mockito.<String>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/{username}", "templNametempfName");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"username\":\"templNametempfName\",\"password\":\"password\",\"firstName\":\"templName\",\"lastName\":\"tempfName\",\"email\":\"templName"
                                        + ".tempfName@example.org\",\"phone\":\"6625550144\",\"profile\":\"Profile\",\"enabled\":true,\"authorities\":[],\"accountNonLocked"
                                        + "\":true,\"accountNonExpired\":true,\"credentialsNonExpired\":true}"));
    }

    @Test
    void testAllUserFromDB2() throws Exception {
        // Arrange
        when(userService.getAllUsersList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/gettingAllUserList");
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testDeleteUSer() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUser(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/{userId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#deleteUSer(Long)}
     */
    @Test
    void testDeleteUSer2() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUser(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/{userId}", 1L);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#updatingUser(User)}
     */
    @Test
    void testUpdatingUser() throws Exception {
        // Arrange
        User user = new User();
        user.setEmail("templName.tempfName@example.org");
        user.setEnabled(true);
        user.setFirstName("templName");
        user.setId(1L);
        user.setLastName("tempfName");
        user.setPassword("password");
        user.setPhone("6625550144");
        user.setProfile("Profile");
        user.setUsername("templNametempfName");
        when(userService.updateUser(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setEmail("templName.tempfName@example.org");
        user2.setEnabled(true);
        user2.setFirstName("templName");
        user2.setId(1L);
        user2.setLastName("tempfName");
        user2.setPassword("password");
        user2.setPhone("6625550144");
        user2.setProfile("Profile");
        user2.setUsername("templNametempfName");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/update-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"username\":\"templNametempfName\",\"password\":\"password\",\"firstName\":\"templName\",\"lastName\":\"tempfName\",\"email\":\"templName"
                                        + ".tempfName@example.org\",\"phone\":\"6625550144\",\"profile\":\"Profile\",\"enabled\":true,\"authorities\":[],\"accountNonLocked"
                                        + "\":true,\"accountNonExpired\":true,\"credentialsNonExpired\":true}"));
    }
}
