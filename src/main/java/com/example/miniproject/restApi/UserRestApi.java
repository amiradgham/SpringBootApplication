package com.example.miniproject.restApi;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.miniproject.impl.UserImp;
import com.example.miniproject.models.User;

@RestController
@RequestMapping("/api/user")
public class UserRestApi {
	
	@Autowired UserImp userImp;
	
	@GetMapping("/all")
    public List<User> findUsers()  {
		return userImp.findUsers();
    }
	
	@GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id")int id)  {
		return userImp.getUserById(id);
    }

    @PostMapping("/update")
    public User personalizeUser(@RequestBody User user) {
        return userImp.personalize(user);
    }

}
