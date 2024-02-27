package com.tulesh.springboot.controller;

import com.tulesh.springboot.config.JwtUtils;
import com.tulesh.springboot.helper.UserNotFoundException;
import com.tulesh.springboot.model.JwtRequest;
import com.tulesh.springboot.model.JwtResponse;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private AuthenticationManager authenticateManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }
        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User is Disabled " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials" + e.getMessage());
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return ((User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<?> exceptionHandler(UserNotFoundException e) {
        return ResponseEntity.ok(e.getMessage());
    }

}
