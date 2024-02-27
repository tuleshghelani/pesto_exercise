package com.tulesh.springboot;

import com.tulesh.springboot.helper.UserFoundException;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.UserRepository;
import com.tulesh.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@EnableCaching
@Slf4j
@SpringBootApplication
@EnableScheduling
public class SimpleTaskManagemetSystemApplication implements CommandLineRunner {
    private static final Log logger = LogFactory.getLog(SimpleTaskManagemetSystemApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(SimpleTaskManagemetSystemApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        try {
            User tempUser = userRepository.findByUsername("admin");
            if(!Objects.equals(tempUser, null)) {
                return;
            }
            User user = new User();
            user.setFirstName("Tulesh");
            user.setLastName("Ghelani");
            user.setUsername("admin");
            user.setEmail("admin@gmail.com");
            user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
            user.setPhone("1234567890");
            user.setProfile("1.png");

            this.userService.createUser(user);
        }catch(UserFoundException e){
            logger.info("Some thing went wrong " + e.getMessage());
            e.printStackTrace();
        }
    }

}
