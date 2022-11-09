package com.example.miniproject.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.impl.UserImp;
import com.example.miniproject.models.LogUser;
import com.example.miniproject.models.User;

@RestController
@RequestMapping("/auth/api")
public class AuthRestApi {
	
	@Autowired UserImp userImp;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
    public ResponseEntity logIn(@RequestBody LogUser user)  {
		return userImp.logIn(user);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/inscription")
    public User inscription(@RequestBody User user)  {
		System.out.println("user"+user);
		return userImp.addUser(user);
    }


}
