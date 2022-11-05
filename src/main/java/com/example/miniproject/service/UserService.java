package com.example.miniproject.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.miniproject.dao.UserRepository;
import com.example.miniproject.exception.UserNotFoundException;
import com.example.miniproject.impl.UserImp;
import com.example.miniproject.models.LogUser;
import com.example.miniproject.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserImp {
	
    private final BCryptPasswordEncoder passwordEncoder;
    
	@Autowired
    private final UserRepository userRepository;


	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	  @Override
	    public User addUser(User user) {
		  user.setJoinDate(LocalDateTime.now());
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

	@Override
	public String getJWTToken(String username) {
		// TODO Auto-generated method stub
		  String secretKey = "mySecretKey";
	        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                .commaSeparatedStringToAuthorityList("ROLE_USER");
	        String token = Jwts
	                .builder()
	                .setId("softtekJWT")
	                .setSubject(username)
	                .claim("authorities",
	                        grantedAuthorities.stream()
	                                .map(GrantedAuthority::getAuthority)
	                                .collect(Collectors.toList()))
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))
	                .signWith(SignatureAlgorithm.HS512,
	                        secretKey.getBytes()).compact();

	        return "Bearer " + token;

	}

	@Override
	public ResponseEntity logIn(LogUser user) {
		// TODO Auto-generated method stub
		 try {
	            String token;
	            String tempUsername = user.getUsername();
	            String password=user.getPassword();
	            User user1 = getUserByUsername(tempUsername);

	            if (user1 == null || !passwordEncoder.matches(password, user1.getPassword())) {
	                return ResponseEntity.status(HttpStatus.OK).body("User Not found With This username");
	            }
	            token = getJWTToken(user.getUsername());
	            return ResponseEntity.status(HttpStatus.OK).body(token);

	        }
	        catch (Exception e) {

	            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
	        }

	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
        Optional<User> user = userRepository.getUserByUsername(username);
        if (user.isEmpty()) throw new UserNotFoundException("No user found with this Phone Number");
        else return userRepository.getUserByUsername(username).orElse(null);
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	 @Override
	    public User personalize(User user){
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        User userToUpdate = userRepository.getUserByUsername(authentication.getName()).orElse(null);
	        if (userToUpdate == null) {
	            throw new UserNotFoundException("User Not Found With This Id !");
	        }
	        userRepository.saveAndFlush(userToUpdate);
	        return userToUpdate;
	    }




}
