package com.example.miniproject.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.example.miniproject.models.LogUser;
import com.example.miniproject.models.User;

public interface UserImp {
    Optional<User> getUserById(int id);
    List<User> findUsers();
    User getUserByUsername(String username);
    String getJWTToken(String username);
    ResponseEntity logIn(LogUser user);
    User addUser(User user);
    User personalize(User user);


}
