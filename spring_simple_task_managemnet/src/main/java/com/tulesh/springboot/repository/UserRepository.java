package com.tulesh.springboot.repository;

import com.tulesh.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String userName);
    public long count();



}
