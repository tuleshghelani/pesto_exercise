package com.tulesh.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import com.tulesh.springboot.config.JwtUtils;
import com.tulesh.springboot.helper.UserNotFoundException;
import com.tulesh.springboot.model.JwtRequest;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.service.impl.UserDetailsServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthenticateController.class})
@ExtendWith(SpringExtension.class)
class AuthenticateControllerTest {
  @Autowired
  private AuthenticateController authenticateController;

  @MockBean
  private AuthenticationManager authenticationManager;

  @MockBean
  private JwtUtils jwtUtils;

  @MockBean
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Test
  void testGenerateToken() throws Exception {
    // Arrange
    when(jwtUtils.generateToken(Mockito.<UserDetails>any())).thenReturn("ABC123");
    when(userDetailsServiceImpl.loadUserByUsername(Mockito.<String>any())).thenReturn(new User("Testuser", "password"));
    when(authenticationManager.authenticate(Mockito.<Authentication>any()))
            .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

    JwtRequest jwtRequest = new JwtRequest();
    jwtRequest.setPassword("password");
    jwtRequest.setUsername("templNametempfName");
    String content = (new ObjectMapper()).writeValueAsString(jwtRequest);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authenticateController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("{\"token\":\"ABC123\"}"));
  }

  /**
   * Method under test:
   * {@link AuthenticateController#exceptionHandler(UserNotFoundException)}
   */
  @Test
  void testExceptionHandler() {
    // Arrange and Act
    ResponseEntity<?> actualExceptionHandlerResult = authenticateController
            .exceptionHandler(new UserNotFoundException("Msg"));

    // Assert
    assertEquals("Msg", actualExceptionHandlerResult.getBody());
    assertEquals(HttpStatus.OK, actualExceptionHandlerResult.getStatusCode());
    assertTrue(actualExceptionHandlerResult.getHeaders().isEmpty());
  }

  /**
   * Method under test:
   * {@link AuthenticateController#exceptionHandler(UserNotFoundException)}
   */
  @Test
  void testExceptionHandler2() {
    // Arrange
    UserNotFoundException e = mock(UserNotFoundException.class);
    when(e.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    ResponseEntity<?> actualExceptionHandlerResult = authenticateController.exceptionHandler(e);

    // Assert
    verify(e).getMessage();
    assertEquals("Not all who wander are lost", actualExceptionHandlerResult.getBody());
    assertEquals(HttpStatus.OK, actualExceptionHandlerResult.getStatusCode());
    assertTrue(actualExceptionHandlerResult.getHeaders().isEmpty());
  }

  @Test
  void testGetCurrentUser() throws Exception {
    // Arrange
    when(userDetailsServiceImpl.loadUserByUsername(Mockito.<String>any())).thenReturn(new User("Testuser", "password"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/current-user");
    requestBuilder.principal(new UserPrincipal("principal"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authenticateController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"id\":null,\"username\":\"Testuser\",\"password\":\"password\",\"firstName\":null,\"lastName\":null,\"email\":null"
                                    + ",\"phone\":null,\"profile\":null,\"enabled\":true,\"authorities\":[],\"accountNonLocked\":true,\"credentialsNonExpired"
                                    + "\":true,\"accountNonExpired\":true}"));
  }
}
